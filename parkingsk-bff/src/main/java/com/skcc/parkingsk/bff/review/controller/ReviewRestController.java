package com.skcc.parkingsk.bff.review.controller;


import com.skcc.parkingsk.bff.member.dto.BookingHistoryDto;
import com.skcc.parkingsk.bff.member.dto.MemberDto;
import com.skcc.parkingsk.bff.review.dto.ReviewDto;
import com.skcc.parkingsk.bff.review.service.ReviewService;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ReviewRestController {

  private final ReviewService reviewService;




@PostMapping("/reviews")
  public void registerReview(HttpSession session, @RequestBody ReviewDto reviewDto) {

	System.out.println("review bff rest controller !!!!  : " + reviewDto);

    // 로그인Id 남길까해서 reviewerId long에서 string으로 변경함
    reviewDto.setReviewerId((String) session.getAttribute("loginId"));
    reviewDto.setReviewerName((String) session.getAttribute("loginName"));

    System.out.println("셋팅 후 reviewDto!!!!  : " + reviewDto);
	reviewService.registerReview(reviewDto);

  }
}

