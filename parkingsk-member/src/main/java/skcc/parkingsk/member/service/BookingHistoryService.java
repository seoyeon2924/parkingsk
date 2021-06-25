package skcc.parkingsk.member.service;

import skcc.parkingsk.member.domain.entity.BookingHistory;
import skcc.parkingsk.member.domain.entity.Member;

import java.util.List;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

public interface BookingHistoryService {

  List<BookingHistory> findBoookingHistoryList(String name);
  BookingHistory booking(BookingHistory bookingHistory);

}
