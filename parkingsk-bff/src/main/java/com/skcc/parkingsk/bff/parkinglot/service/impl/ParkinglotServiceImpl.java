package com.skcc.parkingsk.bff.parkinglot.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.parkinglot.service.ParkinglotService;
import com.skcc.parkingsk.bff.review.dto.ReviewDto;
import com.skcc.parkingsk.bff.review.service.impl.ReviewServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParkinglotServiceImpl implements ParkinglotService{

	private final RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Value("${api.parkinglot.url}")
	private String apiGatewayUrl;
	
	@Override
	public List<ParkingLotDto> searchParkinglotList(String parkinglotNameKeyword) {
		ParkingLotDto[] resultClasses = restTemplate.getForObject(String.format("%s%s%s", apiGatewayUrl, "parkingLots/", parkinglotNameKeyword), ParkingLotDto[].class);
		for (ParkingLotDto parkingLotDto : resultClasses) {
			System.out.println(parkingLotDto);				
		}
		return Arrays.asList(resultClasses);
		
//		ParkingLotDto parkingLotDto = new ParkingLotDto();
//		parkingLotDto.setName("주차장이름");
//		parkingLotDto.setCompanyName("회사이름");
//		parkingLotDto.setArea("지역");
//		parkingLotDto.setId((long)1);
//		
//		ArrayList<ParkingLotDto> list = new ArrayList<>();
//		list.add(parkingLotDto);
//		return list;
	}

	@Override
	public void insertParkinglot(ParkingLotDto parkinglot) {
		System.out.println("insertParkinglot"+parkinglot);				
		this.restTemplate.postForObject(String.format("%s%s", apiGatewayUrl, "parkingLot"),  parkinglot, ParkingLotDto.class);
		
	}

	@Override
	public ParkingLotDto detailParkingLot(Long parkingLotId) {
		
		ParkingLotDto returnClass = this.restTemplate.getForObject(String.format("%s%s%d", apiGatewayUrl, "parkingLot/", parkingLotId), ParkingLotDto.class); 
		return returnClass;
//		
//		ParkingLotDto parkingLotDto = new ParkingLotDto();
//		parkingLotDto.setName("주차장이름");
//		parkingLotDto.setCompanyName("회사이름");
//		parkingLotDto.setArea("지역");
//		parkingLotDto.setId((long)1);
//		return parkingLotDto;
	}

	@Override
	public void deleteParkingLot(Long parkingLotId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
