package skcc.parkingsk.member.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import skcc.parkingsk.member.controller.dto.MemberDto;
import skcc.parkingsk.member.kafka.message.BookingKafkaDto;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */

@Configuration
//@EnableKafka
public class MessageReceiverConfig {

  @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.consumer.topic-name}")
  private String topic;

  @Value(value = "${spring.kafka.consumer.group-id}")
  private String groupId;

  @Bean
  public ConsumerFactory consumerFactory() {
    Map props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//    DefaultKafkaConsumerFactory defaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(props,
//            new StringDeserializer(),
//            new JsonDeserializer<>(BookingKafkaDto.class)); // 요기부분만 바꿔줬음
//    return defaultKafkaConsumerFactory;
    return new DefaultKafkaConsumerFactory<>(props,
        new StringDeserializer(),
        new JsonDeserializer<>(BookingKafkaDto.class, false));
    // false를 넣으니까 정상 동작하는구나ㅠ 감동...
  }



  @Bean
  public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

}
