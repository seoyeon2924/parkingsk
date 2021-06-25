package com.skcc.parkingsk.bff.review.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
public class ReviewDto {

	private Long id;

	private String reviewDate;

	//private Long reviewerId;
	private String reviewerId;
	
	private String reviewerName;
	
	private Long parkingLotId;
	
	private String parkingLotName;

	private String contents;

	private String starPoint;

}
