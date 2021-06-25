package com.skcc.parkingsk.bff.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDto {
	private Long id;
	
	//private Booker booker;
	private String bookerId;
	private String bookerName;
	//private BookParkingLot bookParkingLot;
	private Long parkingLotId;
	private String parkingLotName;

	private String bookdate;
	private String bookCarNo;
	private String bookStatus;
	private String result;
}
