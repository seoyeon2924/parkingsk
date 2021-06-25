package com.skcc.parkingsk.bff.review.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.bff.review.dto.ReviewDto;


public interface ReviewService {

	List<ReviewDto> searchReview(Long parkingLotId);
	
	void registerReview(ReviewDto reviewDto);
}
