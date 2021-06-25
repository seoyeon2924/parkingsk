package com.skcc.parkingsk.booking.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.skcc.parkingsk.booking.domain.entity.Booking;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class MessageSender {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @Value(value = "${spring.kafka.producer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.producer.topic-name}")
  private String topic;

  @Async
  public void send(Booking booking) {

    log.info("sending data=" + booking.toString());

    kafkaTemplate.send(topic, booking);
  }
}