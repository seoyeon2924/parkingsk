package com.skcc.parkingsk.parkinglot.controller.dto;

import com.skcc.parkingsk.parkinglot.domain.vo.Address;
import com.skcc.parkingsk.parkinglot.domain.vo.Location;
import com.skcc.parkingsk.parkinglot.domain.vo.ParkingLotDatail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDTO {

	private Long id;
	
	private String name;
	
	private int capacity;
	
	private String companyName;
	
	private String latitude;
	
	private String longitude;
	
	private String openTime;
	
	private String endTime;
	
	private String address;
	
	private String area;
	
	private String filePath;

	private String contents;
	
}



