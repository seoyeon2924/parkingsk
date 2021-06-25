package com.skcc.parkingsk.booking.service;

import java.util.List;

import com.skcc.parkingsk.booking.domain.dto.BookingDto;
import com.skcc.parkingsk.booking.domain.entity.Booking;

/**
 * @author seoyeon on 2021/05/07
 * @project parkingsk.member
 */

public interface AvailableParkingLotScheduleService {

	int getAvailableCount(Booking booking);

//  public AvailableParkingLotSchedule findAvailableParkingLotScheduleById(Long id);
}
