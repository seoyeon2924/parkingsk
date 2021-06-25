package com.skcc.parkingsk.review.controller.dto;


import java.util.Date;

import com.skcc.parkingsk.review.domain.entity.Review;
import com.skcc.parkingsk.review.domain.enums.StarPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

	private Long id;

	private String reviewDate;

	//private Long reviewerId;
	private  String reviewerId;

	private String reviewerName;

	//private Reviewer reviewer;

	private Long parkingLotId;
	
	private String parkingLotName;

	private String contents;

	private String starPoint;

}
