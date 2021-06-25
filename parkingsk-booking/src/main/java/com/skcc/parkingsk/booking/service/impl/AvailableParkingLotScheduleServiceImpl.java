package com.skcc.parkingsk.booking.service.impl;

import org.springframework.stereotype.Service;

import com.skcc.parkingsk.booking.domain.entity.Booking;
import com.skcc.parkingsk.booking.repository.AvailableParkingLotScheduleRepository;
import com.skcc.parkingsk.booking.service.AvailableParkingLotScheduleService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jimmy on 2021/05/12
 * @project parkingsk.booking
 */

@Slf4j
@AllArgsConstructor
@Service
public class AvailableParkingLotScheduleServiceImpl implements AvailableParkingLotScheduleService {

  private AvailableParkingLotScheduleRepository availableParkingLotScheduleRepository;

  
	// 가용 공간 확인
	@Override
	public int getAvailableCount(Booking booking) {
		
//		AvailableParkingLotSchedule availableParkingLotSchedule = new AvailableParkingLotSchedule();
//		availableParkingLotSchedule.getAvailableParkingLot().setAvailableParkingLotId(booking.getBookParkingLot().getParkingLotId());
//		availableParkingLotSchedule.getAvailableParkingLot().setAvailableParkingLotName(booking.getBookParkingLot().getParkingLotName());
		
		log.info("bookDate : " + booking.getBookdate());
//		return availableParkingLotScheduleRepository.getAvailableCapacity(booking.getBookdate(), booking.getBookParkingLot().getParkingLotId());
		return availableParkingLotScheduleRepository.getAvailableCapacity(booking.getBookdate(), booking.getParkingLotId());
	}


	
  
}
