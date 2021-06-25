package com.skcc.parkingsk.bff.booking.dto;

import com.skcc.parkingsk.bff.review.dto.ReviewDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDto {

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
