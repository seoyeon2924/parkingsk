package com.skcc.parkingsk.parkinglot.controller.dto;

import com.skcc.parkingsk.parkinglot.domain.enums.ParkingLotStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotKafkaDTO {

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

	private ParkingLotStatus parkingLotStatus;
}
