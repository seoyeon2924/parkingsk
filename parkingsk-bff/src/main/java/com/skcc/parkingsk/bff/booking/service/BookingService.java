package com.skcc.parkingsk.bff.booking.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skcc.parkingsk.bff.booking.dto.BookingDto;
import com.skcc.parkingsk.bff.booking.dto.ParkingLotDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {
	private final RestTemplate restTemplate;
	
	@Value("${api.booking.url}")
	private String apiGatewayUrl;
	
	//예약하기
	public BookingDto register(BookingDto bookingDto) {
		return this.restTemplate.postForObject(String.format("%s%s",  apiGatewayUrl, "/bookings/makeBook"), bookingDto, BookingDto.class);
	}
	
	//취소하기
	public void deleteBooking(Long bookingId) {
		  
	};
	    
	public List<ParkingLotDto> searchCloseParkinglotList(String lati, String longi) {
		//String[] latlong = parkinglotLatLong.split(",");
		//String lati = latlong[0];
		//String longi = latlong[1];
		
		ParkingLotDto[] resultClasses = restTemplate.getForObject(String.format("%s%s%s%s%s", apiGatewayUrl, "/", lati, "/", longi), ParkingLotDto[].class);
		for (ParkingLotDto parkingLotDto : resultClasses) {
			System.out.println(parkingLotDto);				
		}
		return Arrays.asList(resultClasses);
		
//		ParkingLotDto parkingLotDto = new ParkingLotDto();
//		parkingLotDto.setName("주차장이름");
//		parkingLotDto.setCompanyName("회사이름");
//		parkingLotDto.setArea("지역");
//		parkingLotDto.setId((long)1);
//		
//		ArrayList<ParkingLotDto> list = new ArrayList<>();
//		list.add(parkingLotDto);
//		return list;
	}
}