package com.skcc.parkingsk.parkinglot.service;


import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotDTO;
import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotKafkaDTO;
import com.skcc.parkingsk.parkinglot.domain.entity.ParkingLot;
import com.skcc.parkingsk.parkinglot.domain.enums.ParkingLotStatus;

import java.util.List;


public interface ParkinglotService {

    /* ParkingLot 전체 조회 */
    public List<ParkingLot> findAll();

    /* ParkingLot 등록 */
    public ParkingLot registerParkingLot(ParkingLotDTO parkingLotDTO);

    /* ParkingLot 삭제 */
    public void deleteParkingLot(Long parkingLotId);

    /* ParkingLot 건별조회 */
    public ParkingLot findParkingLotOne(Long parkingLotId);

    public ParkingLot updateParkingLot(ParkingLotDTO parkingLotDTO);

    public List<ParkingLot> findParkingLotListByName(String parkingLotName);

    public ParkingLotKafkaDTO parkingLotDtoToKafkaDto(ParkingLotDTO parkingLotDTO, ParkingLotStatus parkingLotStatus);

    public List<ParkingLot> findCloseParkingLotListByGeo(String latitude, String longitude);

}
