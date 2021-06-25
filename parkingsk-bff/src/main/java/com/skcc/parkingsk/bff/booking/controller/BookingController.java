package com.skcc.parkingsk.bff.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookingController {
	//1. 예약화면
	@GetMapping("/booking")
	public String registerBooking(HttpSession session, Model model) {
		System.out.println("주차장 예약하기");	
		
		if (session.getAttribute("loginId") != null) {
		    //session.removeAttribute("loginId");	
		    model.addAttribute("loginId", session.getAttribute("loginId"));
			model.addAttribute("loginName", session.getAttribute("loginName"));
		}		
		
		return "booking";		
	}
	
	@GetMapping("/zipkin")
	public String zipkin(HttpSession session, Model model) {
		System.out.println("Zipkin 페이지 이동");	
		return "zipkin";
	}
}
