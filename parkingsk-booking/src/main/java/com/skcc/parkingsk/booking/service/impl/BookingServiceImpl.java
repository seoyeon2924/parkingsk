package com.skcc.parkingsk.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.booking.domain.dto.BookingDto;
import com.skcc.parkingsk.booking.domain.entity.Booking;
import com.skcc.parkingsk.booking.kafka.MessageSender;
import com.skcc.parkingsk.booking.repository.AvailableParkingLotScheduleRepository;
import com.skcc.parkingsk.booking.repository.BookingRepository;
import com.skcc.parkingsk.booking.service.BookingService;

import lombok.AllArgsConstructor;

/**
 * @author Jimmy on 2021/05/13
 * @project parkingsk.booking
 */

//@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	MessageSender producer;
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private AvailableParkingLotScheduleRepository availableParkingLotScheduleRepository;

	// 예약자 정보로 예약정보 조회
	@Override
	public List<Booking> findBookingByBookerId(Long bookerId) {
//		return (List<Booking>) bookingRepository.findAllByBooker_BookerId(bookerId);
		return (List<Booking>) bookingRepository.findAllByBookerId(bookerId);
	}


	@Override
	public BookingDto makeBook(Booking booking) {
		
		bookingRepository.save(booking);
		// kafka Queue 발행 
//		KafkaDto kafkaDto = new KafkaDto();
//		kafkaDto.setName(booking.getBooker().getBookerName());
		producer.send(booking); // 이벤트 발행
		BookingDto resBookingDto = new BookingDto();
		resBookingDto.setResult("Success");
	    return resBookingDto;
	}


	@Override
	public String cancelBook(BookingDto bookingDto) {
		return null;
	}


	// 중복 예약 여부 확인
	@Override
	public int findBookingByBookerIdAndBookDate(Booking booking) {
		
//		return bookingRepository.selectBookingInfo(booking.getBookdate(), booking.getBookCarNo(), booking.getBooker().getBookerId());
		return bookingRepository.selectBookingInfo(booking.getBookdate(), booking.getBookCarNo(), booking.getBookerId());
	}




}
