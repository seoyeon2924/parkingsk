package skcc.parkingsk.member.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */


@Configuration
public class MessageSenderConfig {

  @Value(value = "${spring.kafka.producer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.producer.topic-name}")
  private String topic;

  @Bean
  public ProducerFactory producerFactory() {
    Map configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  public KafkaTemplate kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

}


