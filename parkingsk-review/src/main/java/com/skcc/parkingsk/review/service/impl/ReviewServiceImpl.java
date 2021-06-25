package com.skcc.parkingsk.review.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skcc.parkingsk.review.domain.entity.Review;
import com.skcc.parkingsk.review.repository.ReviewRepository;
import com.skcc.parkingsk.review.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	@Override
	public List<Review> searchReview(Long parkingLotId) {
//		System.out.println("impl : " + reviewRepository.findByParkingLotId(parkingLotId));
		return reviewRepository.findByParkingLotId(parkingLotId);
	}
	
	@Override
	public Review registerReview(Review review) {		
		return reviewRepository.save(review);
		
	}
}
