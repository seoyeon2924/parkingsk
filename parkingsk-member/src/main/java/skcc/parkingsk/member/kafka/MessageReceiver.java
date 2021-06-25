package skcc.parkingsk.member.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import skcc.parkingsk.member.controller.BookingHistoryController;
import skcc.parkingsk.member.domain.entity.BookingHistory;
import skcc.parkingsk.member.domain.enums.BookStatus;
import skcc.parkingsk.member.kafka.message.BookingKafkaDto;
import skcc.parkingsk.member.service.BookingHistoryService;

import java.util.Date;

/**
 * @author seoyeon on 2021/05/13
 * @project skparking
 */
@Service
@RequiredArgsConstructor
public class MessageReceiver {

  private final BookingHistoryService bookingHistoryService;

  @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapServers;

  @Value(value = "${spring.kafka.consumer.topic-name}")
  private String topic;


  //@KafkaListener(topics = "${spring.kafka.consumer.topic-name}")
  @KafkaListener(topics = "BOOKING") // topic 이름 수정 필요
 // public void processMessage(MemberDto memberDto) {
  public void processMessage(BookingKafkaDto bookingKafkaDto) {
    System.out.println("Kafka receiver 호출");
    System.out.println("!!!received content = " + bookingKafkaDto);

    /*
     * 이벤트 수신 후 필요한 로직 작성
     * 이렇게 하는 건 지 알고 싶은데, booking이 event주면 테스트 해보자.
     * */
    //bookingHistoryController.booking(bookingKafkaDto);
    BookingHistory bookingHistory = new BookingHistory();

    bookingHistory.setBookerId(bookingKafkaDto.getBookerId());
    bookingHistory.setBookerName(bookingKafkaDto.getBookerName());
    bookingHistory.setBookParkingLotId(bookingKafkaDto.getParkingLotId());
    bookingHistory.setBokkingParkingLotName(bookingKafkaDto.getParkingLotName());
   //bookingHistory.setBookDate(Date());
    bookingHistory.setBookCarNo(bookingKafkaDto.getBookCarNo());

    // 예약 상태
    // Booking 서비스에 맞게 Booked로 변경
    if (bookingKafkaDto.getBookStatus().equals("BOOKED")) {
      bookingHistory.setBookStatus(BookStatus.RESERVED);
    } else {
      bookingHistory.setBookStatus(BookStatus.CANCELED);
    }

    BookingHistory resultBooking = bookingHistoryService.booking(bookingHistory);

  }

}
