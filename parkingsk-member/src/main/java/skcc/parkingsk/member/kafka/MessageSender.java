package skcc.parkingsk.member.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import skcc.parkingsk.member.controller.dto.MemberDto;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */

@Service
public class MessageSender {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @Value(value = "${spring.kafka.producer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.producer.topic-name}")
  private String topic;

  public void send(MemberDto memberDto) {

    System.out.println("sending data=" + memberDto);

    kafkaTemplate.send(topic, memberDto);
  }
}