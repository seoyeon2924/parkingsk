package com.skcc.parkingsk.parkinglot.domain.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ParkingLotDatail {
	private String filePath;
	private String contents;
}
