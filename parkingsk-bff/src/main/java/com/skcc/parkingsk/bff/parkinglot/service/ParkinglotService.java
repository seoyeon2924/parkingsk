package com.skcc.parkingsk.bff.parkinglot.service;

import java.util.List;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import org.springframework.stereotype.Service;

public interface ParkinglotService {

	public List<ParkingLotDto> searchParkinglotList(String parkinglotNameKeyword);
	
	public ParkingLotDto detailParkingLot(Long parkingLotId);
	
	public void deleteParkingLot(Long parkingLotId);
	
	public void insertParkinglot(ParkingLotDto parkinglot);
	
	
}
