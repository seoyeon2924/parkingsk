package com.skcc.parkingsk.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.parkingsk.booking.domain.dto.BookingDto;
import com.skcc.parkingsk.booking.domain.entity.Booking;
import com.skcc.parkingsk.booking.domain.entity.ParkingLot;
import com.skcc.parkingsk.booking.domain.enums.BookStatus;
import com.skcc.parkingsk.booking.domain.vo.BookParkingLot;
import com.skcc.parkingsk.booking.domain.vo.Booker;
import com.skcc.parkingsk.booking.service.AvailableParkingLotScheduleService;
import com.skcc.parkingsk.booking.service.BookingService;
import com.skcc.parkingsk.booking.service.ParkinglotService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Jimmy on 2021/05/18
 * @project parkingsk.booking
 */

@Slf4j
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
//	@Autowired
//	private ParkinglotService parkinglotService; 
  
	@Autowired
	private AvailableParkingLotScheduleService availableParkingLotScheduleService;
	
	/***
	 * 1. 예약자 정보로 예약내용 조회
	 * 미완성. bookerId가 아닌 Booker(VO)로만 by 검색 가능함... ID로만 검색하는 방법 찾아서 수정 필요
	 * @param bookerId
	 * @return 
	 */
	  @GetMapping("/bookings/booker/{bookerId}")
	  public ResponseEntity<List<Booking>> findBookByMemberId(@PathVariable Long bookerId) {
		  log.info("bookerId : " + bookerId);
//		Booker booker = new Booker(bookerId, null);
	    return ResponseEntity.ok().body(bookingService.findBookingByBookerId(bookerId));
	  }
	  
	  /***
	   * 2. 예약하기
	   * @param booking
	   * @return
	   */
	  @PostMapping("/bookings/makeBook")
	  public BookingDto makeBook(@RequestBody BookingDto bookingDto) {
		  BookingDto resBookingDto = new BookingDto();
		  log.info("bookingDto : " + bookingDto.toString());
		  try {
			  
//	      Booking booking = new Booking();
//		  Booker booker = new Booker();
//		  booking.setBooker(booker);
//		  BookParkingLot bookParkingLot = new BookParkingLot();
//		  booking.setBookParkingLot(bookParkingLot);
//		  booking.setBookCarNo(bookingDto.getBookCarNo());
//		  booking.setBookdate(bookingDto.getBookdate());
//		  booking.getBooker().setBookerId(bookingDto.getBookerId());
//		  booking.getBooker().setBookerName(bookingDto.getBookerName());
//		  booking.getBookParkingLot().setParkingLotId(bookingDto.getParkingLotId());
//	      booking.getBookParkingLot().setParkingLotName(bookingDto.getParkingLotName());
//		  booking.setBookStatus(BookStatus.BOOKED); 
			  Booking booking = new Booking();
//		  booking.setBooker(booker);
//		  booking.setBookParkingLot(bookParkingLot);
			  booking.setBookCarNo(bookingDto.getBookCarNo());
			  booking.setBookdate(bookingDto.getBookdate());
			  booking.setBookerId(bookingDto.getBookerId());
			  booking.setBookerName(bookingDto.getBookerName());
			  booking.setParkingLotId(bookingDto.getParkingLotId());
			  booking.setParkingLotName(bookingDto.getParkingLotName());
			  booking.setBookStatus(BookStatus.BOOKED); 
			  
			  // 주차장의 원하는 날짜에 가용 주차공간 수 확인
			  int availableCount = availableParkingLotScheduleService.getAvailableCount(booking);
			  
			  log.info("가용 주차 공간 : " + availableCount);
			  // 주차공간이 0인 경우 > 예약 실패 리턴
			  if(availableCount>0) {
				  int bookedCount = bookingService.findBookingByBookerIdAndBookDate(booking);
				  if(bookedCount != 0)
					  resBookingDto.setResult("Double Booking Fail (already booked by same car number and same date)");
				  return bookingService.makeBook(booking);
			  }else
				  resBookingDto.setResult("Booking Failed (no available space)");
			  return resBookingDto;
			
		} catch (Exception e) {
//			 resBookingDto.setResult("Fail" + e.toString());
			 resBookingDto.setResult("예약실패(입력값을 확인해 주세요)");
			 return resBookingDto;
		}
	  }
	  
	  /***
	   * 3. 예약취소하기
	   */
	  @PostMapping("/bookings/{bookid}")
	  public String cancelBook(@RequestBody BookingDto bookingDto) {
		  if(bookingDto.getId() != null)
			  return "Fail ID is mendatory";
		  
		  return bookingService.cancelBook(bookingDto);
	  }
	  
	  
//	    /* 위도 경도에 따른 가까운 주차장 3개 반환 */
//	    @GetMapping("/{latitude}/{longitude}")
//	    public List<ParkingLot> findCloseParkingLot(@PathVariable String latitude, String longitude){
//	        log.info("***************** ParkinglotController : 가까운주차장 3개찾기 GetMapping 호출 *****************");
//	        return parkinglotService.findCloseParkingLotListByGeo(latitude, longitude);
//	    }
	  
	  
}
