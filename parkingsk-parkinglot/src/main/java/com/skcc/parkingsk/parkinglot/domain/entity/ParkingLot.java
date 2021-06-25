package com.skcc.parkingsk.parkinglot.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.skcc.parkingsk.parkinglot.domain.vo.Address;
import com.skcc.parkingsk.parkinglot.domain.vo.Location;
import com.skcc.parkingsk.parkinglot.domain.vo.ParkingLotDatail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="parking_lot")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="company_name")
	private String companyName;
	
//	@Column(name="location")
//	private Location location;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;

	
	@Column(name="openTime")
	private String openTime;
	
	@Column(name="endTime")
	private String endTime;
	
//	@Column(name="address")
//	private Address address;
	
	@Column(name="address")
	private String address;
	
	@Column(name="area")
	private String area;
	
//	
//	@Column(name="parking_lot_detail")
//	private ParkingLotDatail parkingLotDetail;
//	
	@Column(name="filePath")
	private String filePath;
	
	@Column(name="contents")
	private String contents;

	
}
