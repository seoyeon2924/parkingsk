package com.skcc.parkingsk.booking.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.skcc.parkingsk.booking.domain.dto.BookingDto;
import com.skcc.parkingsk.booking.domain.entity.Booking;

/**
 * @author seoyeon on 2021/05/07
 * @project parkingsk.member
 */

public interface BookingService {

//  Booking findBookingById(Long id);

  List<Booking> findBookingByBookerId(Long bookerId);

  BookingDto makeBook(Booking booking);

  String cancelBook(BookingDto bookingDto);

  int findBookingByBookerIdAndBookDate(Booking booking);

//  int getAvailableCount(Booking booking);

}
