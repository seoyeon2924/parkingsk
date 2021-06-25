package com.skcc.parkingsk.review.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.jandex.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skcc.parkingsk.review.controller.dto.ReviewDto;
import com.skcc.parkingsk.review.domain.entity.Review;
import com.skcc.parkingsk.review.event.MessageSender;
import com.skcc.parkingsk.review.event.message.KafkaDto;
import com.skcc.parkingsk.review.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RestController
@RequiredArgsConstructor
public class ReviewController {
	  
	private final ReviewService reviewService;
	private final ModelMapper modelMapper;
	
	@Autowired
	MessageSender producer;
	  
	/**
	 * parkingLotId로 해당 주차장에 등록 된 리뷰 조회
	 * @param parkingLotId
	 * @return
	*/	
	@GetMapping("/reviews/{parkingLotId}")
	public List<ReviewDto> searchReview(@PathVariable Long parkingLotId) {

		List<Review> reviewList = reviewService.searchReview(parkingLotId);
		System.out.println("parkingLotId로 해당 주차장에 등록 된 리뷰 조회 controller 호출");
		System.out.println("reviewList : " + reviewList);
		
		// Review 엔티티를 ReviewDto로 변환
		List<ReviewDto> reviewDtoList = reviewList.stream().map(m-> modelMapper.map(m, ReviewDto.class)).collect(Collectors.toList());
		return reviewDtoList;			
	}	

	
	/**
	 * 주차장 리뷰 등록
	 * @param ReviewDto
	 * @return
	*/
	@PostMapping("/reviews")
	public Review registerReview(@RequestBody ReviewDto reviewDto) {
		
		System.out.println("주차장 리뷰 등록 controller 호출");
		System.out.println("msa reviewDto : " + reviewDto);
		// Dto를 Entity로 변환
		Review review = modelMapper.map(reviewDto, Review.class);
		
	//	System.out.println("review 엔티티 " + review);		

//		KafkaDto kafkaDto = new KafkaDto();
//		kafkaDto.setContents(review.getContents());
		//kafkaDto.setStarPoint(review.getStarPoint());
//		kafkaDto.setReviewerId(review.getReviewerId());
//		kafkaDto.setStatus("리뷰등록");
//
//		producer.send(kafkaDto);
		return reviewService.registerReview(review);
//		
		
	}
}

