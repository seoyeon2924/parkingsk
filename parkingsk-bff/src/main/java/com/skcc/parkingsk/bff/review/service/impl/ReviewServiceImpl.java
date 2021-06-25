package com.skcc.parkingsk.bff.review.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.skcc.parkingsk.bff.member.dto.MemberDto;
import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.review.dto.ReviewDto;
import com.skcc.parkingsk.bff.review.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);

	@Value("${api.review.url}")
	private String apiGatewayUrl;
	
	@Override
	public List<ReviewDto> searchReview(Long parkingLotId) {
		
		try {
			ReviewDto[] resultClasses = restTemplate.getForObject(String.format("%s%s%d", apiGatewayUrl, "/reviews/", parkingLotId), ReviewDto[].class);
			
			for(ReviewDto reviewDto : resultClasses) {
				System.out.println("---------------------------resultClasses : " +  reviewDto);
			}
			return Arrays.asList(resultClasses);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void registerReview(ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		System.out.println("BFF review service : " + reviewDto);

		
	   this.restTemplate
	            .postForObject(String.format("%s%s", apiGatewayUrl, "/reviews"), reviewDto, ReviewDto.class);
	}	

}

