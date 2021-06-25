package com.skcc.parkingsk.booking.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

/**
 * 주차장 ID와 거리를 저장, 거리를 비교 하여 sort할수 있도록함
 *
 */
public class ParkingCompare implements Comparable<ParkingCompare> {

	Long parkingLotId;
	double distance;
	
	@Override
	public int compareTo(ParkingCompare o) {
		if (this.distance < o.distance) {
            return -1;
        } else if (this.distance < o.distance) {
            return 0;
        } else {
            return 1;
        }
	}
}
