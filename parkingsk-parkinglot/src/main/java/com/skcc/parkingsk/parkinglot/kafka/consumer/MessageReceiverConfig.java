package com.skcc.parkingsk.parkinglot.kafka.consumer;

import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotKafkaDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinjinjin 2021/05/23
 * @project skparking
 */

@Configuration
@EnableKafka
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
        DefaultKafkaConsumerFactory defaultKafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JsonDeserializer<>(ParkingLotKafkaDTO.class)); // 요기부분만 바꿔줬음
        return defaultKafkaConsumerFactory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}