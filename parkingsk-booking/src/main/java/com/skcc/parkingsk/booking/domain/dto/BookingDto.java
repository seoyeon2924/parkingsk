package com.skcc.parkingsk.booking.domain.dto;

import com.skcc.parkingsk.booking.domain.enums.BookStatus;

import lombok.Data;

@Data
public class BookingDto {
	  
	  private Long id;	  
	  private String bookdate;		 
	  private String bookCarNo;	  
	  private BookStatus bookStatus;	
	  private String bookerId;
	  private String bookerName;
	  private Long parkingLotId;
	  private String parkingLotName;	
	  private String result;
}
