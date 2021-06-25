package com.skcc.parkingsk.bff.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.parkingsk.bff.booking.dto.BookingDto;
import com.skcc.parkingsk.bff.booking.dto.ParkingLotDto;
import com.skcc.parkingsk.bff.booking.service.BookingService;


import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class BookingRestController {
	 	private final BookingService bookingService;
	 	
		@PostMapping("/closeparkinglot")
		public ResponseEntity<List<ParkingLotDto>> searchCloseParkinglotList(@RequestBody HashMap<String, String> parkinglotLatLong) {
			
			System.out.println("post Method"+parkinglotLatLong);
			List<ParkingLotDto> result = bookingService.searchCloseParkinglotList(parkinglotLatLong.get("lati"), parkinglotLatLong.get("longi"));
		
			System.out.println("result"+result.size());
			System.out.println("## BFF의 RestContoller /bookingservice_parkinglot");

			return ResponseEntity.ok().body(result);
		}
	 	
	 	/* 예약 등록 */
	    @PostMapping("/bookingregister")
	    public ResponseEntity<BookingDto> register(HttpSession session, @RequestBody BookingDto bookingDto) {
	    	
	    	
	    	// 예약자 세션정보로 변경 
	    	if (session.getAttribute("loginId") !=null) {
	    	  	bookingDto.setBookerId((String)session.getAttribute("loginId"));
		    	bookingDto.setBookerName((String) session.getAttribute("loginName"));
	    	}
	    		    	
	    	System.out.println("## BFF의 RestContoller /bookingregister --getBookerId");
	    	System.out.println(bookingDto.getBookerId());
	    	System.out.println("## BFF의 RestContoller /bookingregister --getBookerName");
	    	System.out.println(bookingDto.getBookerName());
	    	System.out.println("## BFF의 RestContoller /bookingregister --getStatus");
	    	System.out.println(bookingDto.getBookStatus());
	    	System.out.println("## BFF의 RestContoller /bookingregister --getdate");
	    	System.out.println(bookingDto.getBookdate());
	    	System.out.println("## BFF의 RestContoller /bookingregister --getAvailableParkingLotId");
	    	System.out.println(bookingDto.getParkingLotId());
	    	System.out.println("## BFF의 RestContoller /bookingregister --getAvailableParkingLotName");
	    	System.out.println(bookingDto.getParkingLotName());

	        return new ResponseEntity<BookingDto>(bookingService.register(bookingDto), HttpStatus.OK);
	      }   
	    
	    /* 예약 업데이트 */
	    @PostMapping("/bookingupdate")
	    public String bookingUpdate(@RequestBody Map<String, Object> params){
	       
	    	return "";
	    }

	    /* 예약 삭제 */
	    @PostMapping("/bookingdelete")
	    public void bookingDelete(@RequestBody Map<String, Object> params){
	    	
	    }

}