package com.skcc.parkingsk.parkinglot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.parkinglot.controller.dto.MemberKafkaDTO;
import com.skcc.parkingsk.parkinglot.controller.dto.ReviewKafkaDTO;

@Service
@Slf4j
public class ParkingLotConsumer {
	//@KafkaListener(topics = "${spring.kafka.consumer.topic-name}")
	@KafkaListener(topics="member")
	public void processMemeber(MemberKafkaDTO memberDto) {
		log.info("********* ParkingLotConsumer : Kafka Listener : processMember *********");
		log.debug(String.valueOf(memberDto));
		// 이제 member를 받아서 할 것은 ?
	}
	
	//review가 등록되었을때 수신
	@KafkaListener(topics="review")
	public void processReview(ReviewKafkaDTO reviewDto) {
		log.info("********* ParkingLotConsumer : Kafka Listener : processReview *********");
		log.debug(String.valueOf(reviewDto));
		// 이제 리뷰를 받아서 할 것은?
	}
	
	
}
