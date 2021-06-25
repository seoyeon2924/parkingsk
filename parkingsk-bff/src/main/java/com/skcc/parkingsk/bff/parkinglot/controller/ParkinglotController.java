package com.skcc.parkingsk.bff.parkinglot.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.parkinglot.service.ParkinglotService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ParkinglotController {
	
	final ParkinglotService parkinglotService;

	@GetMapping("/parkinglot")
	public String searchParkinglotList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String userId = null;
		if(session != null ) {
			//session에서 id를 가져오도록
			Object login = session.getAttribute("LOGIN"); //login객체가 뭐가 될지 member 로그인할때 정해줘야됨
		}
		
		System.out.println("parkinglot userId="+userId);
		System.out.println("## BFF의 Controller의 /parkinglot");
//		model.addAttribute("userId", userId); //화면에서 요걸가져다 id를 보여줌??
		model.addAttribute("userId", "Master");
		
		
		return "parkinglot_list";
	}
	
	@GetMapping("/parkinglotregister")
	public String registerParkingLot() {
                              
		System.out.println("parkinglotregister");
		
		
		return "parkinglot_register";

		
	}
	@GetMapping("/detailParkingLot/{parkingLotId}")
	public String detailParkingLot(@PathVariable Long parkingLotId, final Model model) {
		System.out.println("detailParkingLot"+parkingLotId);

		ParkingLotDto parkingLot = parkinglotService.detailParkingLot(parkingLotId);

		System.out.println(parkingLot);

		model.addAttribute("parkingLot", parkingLot);
		return "parkinglot_detail";
	}
}
