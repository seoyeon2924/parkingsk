package com.skcc.parkingsk.parkinglot.controller.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewKafkaDTO {

	private Long id;

	private String reviewDate;

	private Long reviewerId;
	
	private String reviewerName;
	
	private Long parkingLotId;
	
	private String parkingLotName;

	private String contents;

	private String starPoint;

}
