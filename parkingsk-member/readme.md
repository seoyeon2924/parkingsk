## 동기통신(RestTemplete 이용)

## 1. BFF -> MSA로 get요청 !

### 1.1 BFF의 Application.java(메인함수가 있는 클래스) 에 RestTemplate 를 빈으로 추가

```java
@SpringBootApplication
    public class Application {

        public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
```

### 1.2 BFF의 service.java

```java
private final RestTemplate restTemplate; // 서비스 안에 restTemplate 추가

@Override
public void testRestTempleteGet(Long id) {
MemberDto returnMemberDto = this.restTemplate
.getForObject(String.format("%s%s%d", "http://localhost:8081", "/testRestTempleteGet/", id),
MemberDto.class); // localhost:8081(MSA)에서 리턴하는 memberDto를 반환 받을 수 있음

System.out.println(returnMemberDto.getLoginId());
System.out.println(returnMemberDto.getName());
}
```

### 1.3 MSA의 Controller.java

```java
// MSA 에서 !
@GetMapping(value = "/testRestTempleteGet/{id}")
public MemberDto testRestTempleteGet(@PathVariable long id) {

MemberDto memberDto = new MemberDto();
memberDto.setLoginId("testID");
memberDto.setName("seoyeon");

return memberDto;
}
```

---

## 2. BFF -> MSA로 Post요청 !

### 2.1 BFF의 Service.java

```java
private final RestTemplate restTemplate; // 서비스 안에 restTemplate 추가

@Override
public void testRestTempletePost(MemberDto memberDto) {
// 자 나는 BFF야, MSA에게 포스트 매핑을 던져보자

memberDto.setName("안서연BFF이름");
memberDto.setLoginId("안서연BFF로그인아이디");
MemberDto returnMemberDto = this.restTemplate
.postForObject(String.format("%s%s", "http://localhost:8081", "/testRestTempletePost"),
memberDto, MemberDto.class); // localhost:8081(MSA에서 리턴 하는 memberDto를 반환받을 수 있음

System.out.println(returnMemberDto.getName());
System.out.println(returnMemberDto.getLoginId());

}
```

### 2.2 MSA의 Controller.java

```java
//MSA
@PostMapping(value = "/testRestTempletePost")
public MemberDto testRestTempletePost(@RequestBody MemberDto memberDto) {

System.out.println("BFF에서 보낸 memberDto Name: " + memberDto.getName());
System.out.println("BFF에서 보낸 memberDto LoginId: " + memberDto.getLoginId());

memberDto.setName("안서연MSA이름");
memberDto.setLoginId("안서연 MSA 로그인아이디");

return memberDto;
}
```

---
---
---
# Kafka 샘플코드
## 1. 브로커 서버로 이벤트 발행하기 (Producer)
### 1.1 MessageReceiverConfig.java
```java
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
import org.springframework.kafka.support.serializer.JsonDeserializer;
import skcc.parkingsk.member.controller.dto.MemberDto;

/**
 * @author seoyeon on 2021/05/13
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
    return new DefaultKafkaConsumerFactory<>(props,
        new StringDeserializer(),
        new JsonDeserializer<>(MemberDto.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

}
```


### 1.2 MessageSender.java
```java
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
```


### 1.3 MessageSender
```java
/*
비동기로 전달할 데이터 셋팅 
*/
producer.send(memberDto); // 이벤트 발행
```

---

## 2. 브로커로부터 이벤트 수신하기 
### 2.1 MessageReceiverConfig.java
```java
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
import org.springframework.kafka.support.serializer.JsonDeserializer;
import skcc.parkingsk.member.controller.dto.MemberDto;

/**
 * @author seoyeon on 2021/05/13
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
    return new DefaultKafkaConsumerFactory<>(props,
        new StringDeserializer(),
        new JsonDeserializer<>(MemberDto.class));
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }

}

```

### 2.2 MessageReceiver.java
```java
package skcc.parkingsk.member.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import skcc.parkingsk.member.controller.dto.MemberDto;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */
@Service
public class MessageReceiver {

  @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.consumer.topic-name}")
  private String topic;


  @KafkaListener(topics = "${spring.kafka.consumer.topic-name}")
  public void processMessage(MemberDto memberDto) {
    System.out.println("!!!received content = " + memberDto);
    System.out.println(memberDto.getName());
    System.out.println(memberDto.getLoginId());

    /*
     * 이벤트 수신 후 필요한 로직 작성
     * */
  }

}
```

