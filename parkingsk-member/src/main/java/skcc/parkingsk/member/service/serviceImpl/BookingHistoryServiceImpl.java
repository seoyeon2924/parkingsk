package skcc.parkingsk.member.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skcc.parkingsk.member.domain.entity.BookingHistory;
import skcc.parkingsk.member.domain.entity.Member;
import skcc.parkingsk.member.repository.BookingHistoryRepository;
import skcc.parkingsk.member.service.BookingHistoryService;

import java.util.List;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

@Service
@RequiredArgsConstructor
public class BookingHistoryServiceImpl implements BookingHistoryService {

  private final BookingHistoryRepository bookingHistoryRepository;

  public List<BookingHistory> findBoookingHistoryList(String name) {
    return bookingHistoryRepository.findBoookingHistoryList(name);
  }


  @Override
  public BookingHistory booking(BookingHistory bookingHistory) {
    System.out.println("서비스 단의 bookingHistory: "+ bookingHistory);
    BookingHistory savedBooking = bookingHistoryRepository.save(bookingHistory);
    return savedBooking;
  }
}
