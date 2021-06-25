package com.skcc.parkingsk.bff.review.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.review.dto.ReviewDto;
import com.skcc.parkingsk.bff.review.service.ReviewService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReviewController {

	
	private final ReviewService reviewService;
	
	@GetMapping("/reviews/{parkingLotId}")
	public String searchReview(HttpServletRequest request, @PathVariable Long parkingLotId, Model model) {
		
		HttpSession session = request.getSession();
		String userId = null;
		
		if(session != null ) {
			//session에서 id를 가져오도록
			Object login = session.getAttribute("LOGIN"); //login객체가 뭐가 될지 member 로그인할때 정해줘야됨
		}

		
		System.out.println("------------searchReview parkingLotId : "+parkingLotId);
		List<ReviewDto> dtoList = reviewService.searchReview(parkingLotId);
		
		model.addAttribute("dtoList", dtoList);

		return "review_list";
	}
	
	  @GetMapping("/reviews")
	  public String register(HttpSession session, Model model) {

		  System.out.println("review bff controller !!!!");
		  model.addAttribute("loginId", session.getAttribute("loginId"));

	    return "review_register";
	  }
}
