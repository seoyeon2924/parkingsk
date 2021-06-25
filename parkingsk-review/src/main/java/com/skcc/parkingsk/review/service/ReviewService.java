package com.skcc.parkingsk.review.service;

import java.util.List;


import com.skcc.parkingsk.review.controller.dto.ReviewDto;
import com.skcc.parkingsk.review.domain.entity.Review;

public interface ReviewService {

	List<Review> searchReview(Long parkingLotId);
	Review registerReview(Review review);
}
