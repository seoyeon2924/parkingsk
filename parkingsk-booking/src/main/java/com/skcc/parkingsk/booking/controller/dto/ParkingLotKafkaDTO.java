package com.skcc.parkingsk.booking.controller.dto;

//import com.skcc.parkingsk.booking.domain.enums.ParkingLotStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotKafkaDTO {

	private Long id;
	private String name;
	private int capacity;
//	private ParkingLotStatus parkingLotStatus;
	private String parkingLotStatus;
}
