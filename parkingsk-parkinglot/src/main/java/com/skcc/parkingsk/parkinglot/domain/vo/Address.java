package com.skcc.parkingsk.parkinglot.domain.vo;


import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
	
	private String address;
	private String area;

}
