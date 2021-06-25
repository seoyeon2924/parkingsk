package com.skcc.parkingsk.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.parkingsk.booking.domain.entity.ParkingLot;
import com.skcc.parkingsk.booking.service.ParkinglotService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jimmy on 2021/05/18
 * @project parkingsk.booking
 */

@Slf4j
@RestController
public class ParkingLotController {

	@Autowired
	private ParkinglotService parkinglotService; 
  
	  
	    /* 위도 경도에 따른 가까운 주차장 3개 반환 */
	    @GetMapping("/{latitude}/{longitude}")
	    public List<ParkingLot> findCloseParkingLot(@PathVariable String latitude, @PathVariable String longitude){
	        log.info("***************** ParkinglotController : 가까운주차장 3개찾기 GetMapping 호출 *****************");
	        return parkinglotService.findCloseParkingLotListByGeo(latitude, longitude);
	    }
	  
	  
}
