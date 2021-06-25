package com.skcc.parkingsk.parkinglot.service.impl;

import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotDTO;
import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotKafkaDTO;
import com.skcc.parkingsk.parkinglot.domain.entity.ParkingLot;
import com.skcc.parkingsk.parkinglot.domain.enums.ParkingLotStatus;
import com.skcc.parkingsk.parkinglot.kafka.producer.ParkingLotProducer;
import com.skcc.parkingsk.parkinglot.repository.ParkingLotRepository;
import com.skcc.parkingsk.parkinglot.service.ParkingCompare;
import com.skcc.parkingsk.parkinglot.service.ParkinglotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.skcc.parkingsk.parkinglot.domain.enums.ParkingLotStatus.PARKINGLOT_REGISTERED;
import static com.skcc.parkingsk.parkinglot.domain.enums.ParkingLotStatus.PARKINGLOT_UPDATED;


@RequiredArgsConstructor
@Service
@Slf4j
public class ParkinglotServiceImpl implements ParkinglotService {

    private final ParkingLotRepository parkingLotRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final ParkingLotProducer parkingLotProducer;

    /* ParkingLot 전체 조회 */
    @Override
    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    /* ParkingLot 등록 */
    @Override
    public ParkingLot registerParkingLot(ParkingLotDTO parkingLotDTO){
        log.info("********* registerParkingLot *********");
        log.debug(String.valueOf(parkingLotDTO));
        /* ParkingLot의 등이 일어날 때마다 kafka로 Booking MSA에 status = REGISTERED 로 비동기 통신한다 */
        /* 1. DTO <=> KafkaDTO간 형변환 */
        ParkingLotKafkaDTO parkingLotKafkaDTO = parkingLotDtoToKafkaDto(parkingLotDTO, PARKINGLOT_REGISTERED);
        log.debug(String.valueOf(parkingLotKafkaDTO));

        /* 2. 변환된 KafkaDTO를 Producer에서 send */
        parkingLotProducer.sendMessage(parkingLotKafkaDTO);

        /* 3. ParkingLot 등록 */
        ParkingLot parkingLot= modelMapper.map(parkingLotDTO, ParkingLot.class);
        log.debug(String.valueOf(parkingLot));
        return parkingLotRepository.save(parkingLot);
    }

    /* ParkingLot 삭제 */
    @Override
    public void deleteParkingLot(Long parkingLotId){
        log.info("********* deleteParkingLot *********");
        ParkingLot parkingLot = parkingLotRepository.findByParkingLotId(parkingLotId);
        parkingLotRepository.delete(parkingLot);
    }

    /* ParkingLot 상세 조회 */
    @Override
    public ParkingLot findParkingLotOne(Long parkingLotId) {
        return parkingLotRepository.findByParkingLotId(parkingLotId);
    }

    /* ParkingLot Name을 통한 다건 조회*/
    @Override
    public List<ParkingLot> findParkingLotListByName(String parkingLotName){
        return parkingLotRepository.findByNameContainingIgnoreCase(parkingLotName);
    }

    /* ParkingLot 수정 */
    @Override
    public ParkingLot updateParkingLot(ParkingLotDTO parkingLotDTO){
        log.info("********* updateParkingLot *********");
        log.debug(String.valueOf(parkingLotDTO));
        /* ParkingLot의 수정이 일어날 때마다 kafka로 Booking MSA에 status = UPDATED로 비동기 통신한다 (잔여좌석수를 위함)*/
        /* 1. DTO <=> KafkaDTO간 형변환 */
        ParkingLotKafkaDTO parkingLotKafkaDTO = parkingLotDtoToKafkaDto(parkingLotDTO, PARKINGLOT_UPDATED);
        log.debug(String.valueOf(parkingLotKafkaDTO));

        /* 2. 변환된 KafkaDTO를 Producer에서 send */
        parkingLotProducer.sendMessage(parkingLotKafkaDTO);

        /* 3. 수정 로직 */
        ParkingLot newParkingLot= modelMapper.map(parkingLotDTO, ParkingLot.class);
            ParkingLot parkinglot = newParkingLot;
            return parkingLotRepository.save(parkinglot);
    }

    /* ParkingLot의 Kafka통신을 위한 ParkingLotDTO <-> ParkingLotKafkaDTO 변환 */
    @Override
    public ParkingLotKafkaDTO parkingLotDtoToKafkaDto(ParkingLotDTO parkingLotDTO, ParkingLotStatus parkingLotStatus){
        log.info("********* parkingLotDtoToKafkaDto *********");
        ParkingLotKafkaDTO parkingLotKafkaDTO = new ParkingLotKafkaDTO();
        parkingLotKafkaDTO.setId(parkingLotDTO.getId());
        parkingLotKafkaDTO.setName(parkingLotDTO.getName());
        parkingLotKafkaDTO.setCapacity(parkingLotDTO.getCapacity());
        parkingLotKafkaDTO.setCompanyName(parkingLotDTO.getCompanyName());
        parkingLotKafkaDTO.setLatitude(parkingLotDTO.getLatitude());
        parkingLotKafkaDTO.setLongitude(parkingLotDTO.getLongitude());
        parkingLotKafkaDTO.setOpenTime(parkingLotDTO.getOpenTime());
        parkingLotKafkaDTO.setEndTime(parkingLotDTO.getEndTime());
        parkingLotKafkaDTO.setAddress(parkingLotDTO.getAddress());
        parkingLotKafkaDTO.setArea(parkingLotDTO.getArea());
        parkingLotKafkaDTO.setFilePath(parkingLotDTO.getFilePath());
        parkingLotKafkaDTO.setContents(parkingLotDTO.getContents());
        parkingLotKafkaDTO.setParkingLotStatus(parkingLotStatus);
        return parkingLotKafkaDTO;
    }

    /**
     * ParkingLot 위도 경도에 따른 거리가 가까운 3개 주차장 정보 반환
     */
	@Override
	public List<ParkingLot> findCloseParkingLotListByGeo(String latitude, String longitude) {
		
		//입력값에 따라 두 지점 사이의 거리를 구하고 주차장id와 거리를 저장
		List<ParkingLot> parkingLotList = parkingLotRepository.findAll();
		ParkingCompare[] list = new ParkingCompare[parkingLotList.size()];
		
		for (int i =0; i< parkingLotList.size() ; i++){
			ParkingLot parkingLot = parkingLotList.get(i);
			double distance = getDisctance(
					Double.parseDouble(latitude), Double.parseDouble(parkingLot.getLatitude()),
					Double.parseDouble(latitude), Double.parseDouble(parkingLot.getLatitude()));
			list[i] = new ParkingCompare(parkingLot.getId(), distance);
		}
		
		// 거리가 작은것으로 오름차순
		Arrays.sort(list);
		
		List<ParkingLot> result = new ArrayList<ParkingLot>();
		for(int i =0; i<list.length;i++) {
			if(i > 2) {
				//2보다 클때 멈춰야됨
				break;
			}
			result.add(parkingLotRepository.findByParkingLotId(list[i].getParkingLotId()));
		}
		
		return result;
	}

	private double getDisctance(double latitude1, double longitude1, double latitude2, double longitude2) {
		
		return Math.sqrt(Math.pow(latitude1-latitude2, 2)+ Math.pow(longitude1-longitude2, 2));
		
	}


}
