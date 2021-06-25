package com.skcc.parkingsk.parkinglot.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotKafkaDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingLotProducer {

	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Value(value = "${spring.kafka.producer.bootstrap-servers}")
	private String bootstrapServers;

	@Value(value = "${spring.kafka.producer.topic-name}")
	private String topic;


	public void sendMessage(ParkingLotKafkaDTO parkingLotKafkaDTO) {

		log.info("********* ParkingLotProducer : Kafka Sender : sendMessage *********");
		log.debug(String.valueOf(parkingLotKafkaDTO));

		kafkaTemplate.send(topic, parkingLotKafkaDTO);

	}
	
}
