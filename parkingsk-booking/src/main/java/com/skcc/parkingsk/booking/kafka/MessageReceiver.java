package com.skcc.parkingsk.booking.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.booking.domain.enums.ParkingLotStatus;
import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotKafkaDTO;





@Service
public class MessageReceiver {

//  @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
//  private String bootstrapServers;
//
//  @Value(value = "${spring.kafka.consumer.topic-name}")
//  private String topic;


  @KafkaListener(topics="CAPACITY")
  public void processMessage(ParkingLotKafkaDTO parkingLotKafkaDTO) {
	  System.out.println("********* ParkingLotConsumer : Kafka Listener : processMember *********");
	  System.out.println("!!!received content = " + String.valueOf(parkingLotKafkaDTO));

	  if(parkingLotKafkaDTO.getParkingLotStatus().equals(ParkingLotStatus.PARKINGLOT_REGISTERED)) {
		  System.out.println("********* PARKINGLOT_REGISTERED : 주차장 신규 등록 *********");
		  
	  }else if(parkingLotKafkaDTO.getParkingLotStatus().equals(ParkingLotStatus.PARKINGLOT_UPDATED)) {
		  System.out.println("********* PARKINGLOT_REGISTERED : 주차장 정보 수정 *********");
		  
	  }
    /*
     * 이벤트 수신 후 필요한 로직 작성
     * */
  }
  
  

}
