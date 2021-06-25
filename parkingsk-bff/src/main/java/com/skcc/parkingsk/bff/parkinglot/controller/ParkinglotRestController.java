package com.skcc.parkingsk.bff.parkinglot.controller;

import java.net.http.HttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.parkinglot.service.ParkinglotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ParkinglotRestController {
	
	final ParkinglotService parkinglotService;
	
	@PostMapping("/parkinglot")
	public ResponseEntity<List<ParkingLotDto>> searchParkinglotList(@RequestBody HashMap<String, String> parkinglotNameKeyword) {
		
		System.out.println("post Method"+parkinglotNameKeyword);
		List<ParkingLotDto> result = parkinglotService.searchParkinglotList(parkinglotNameKeyword.get("name"));
	
		System.out.println("result"+result.size());
		System.out.println("## BFF의 RestContoller /parkinglot");

		return ResponseEntity.ok().body(result);
	}
	
	
	@PostMapping("/parkinglotregister")
	public void registerParkingLot(
			@RequestBody Map<String, Object> params) {
		
		System.out.println("post"+params);
		System.out.println("parkinglotregister");
		
		ParkingLotDto parkinglot = new ParkingLotDto();
		parkinglot.setName((String) params.get("name"));
		parkinglot.setCompanyName((String) params.get("companyName"));
		parkinglot.setCapacity(Integer.parseInt(((String)params.get("capacity"))));
		parkinglot.setLatitude((String) params.get("latitude"));
		parkinglot.setLongitude((String) params.get("longitude"));
		parkinglot.setOpenTime((String) params.get("openTime"));
		parkinglot.setEndTime((String) params.get("endTime"));
		parkinglot.setAddress((String) params.get("address"));
		parkinglot.setArea((String) params.get("area"));
		
		parkinglotService.insertParkinglot(parkinglot);
		
	}
	
	
	
	public String updateParkingLot() {
		return "";
	}
	
	public String deleteParkingLot() {
		return "";
	}
		
}
