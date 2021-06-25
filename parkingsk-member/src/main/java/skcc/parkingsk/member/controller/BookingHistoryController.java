package skcc.parkingsk.member.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import skcc.parkingsk.member.controller.dto.BookingDto;
import skcc.parkingsk.member.controller.dto.LoginDto;
import skcc.parkingsk.member.controller.dto.MemberDto;
import skcc.parkingsk.member.domain.entity.BookingHistory;
import skcc.parkingsk.member.domain.entity.Member;
import skcc.parkingsk.member.domain.enums.BookStatus;
import skcc.parkingsk.member.domain.enums.MemberStatus;
import skcc.parkingsk.member.domain.enums.RoleType;
import skcc.parkingsk.member.domain.vo.Login;
import skcc.parkingsk.member.kafka.message.BookingKafkaDto;
import skcc.parkingsk.member.service.BookingHistoryService;
import skcc.parkingsk.member.service.MemberService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */
@RestController
@RequiredArgsConstructor
public class BookingHistoryController {

    private final BookingHistoryService bookingHistoryService;
    private final ModelMapper modelMapper;

    @GetMapping("/mypage/{name}")
    public List<BookingDto> findBoookingHistoryList(@PathVariable String name) {

        List<BookingHistory> bookingHistoryList = bookingHistoryService.findBoookingHistoryList(name);
        System.out.println("bookingHistoryList : " + bookingHistoryList);

        List<BookingDto>  returnBookingHistory = bookingHistoryList.stream().map(m-> modelMapper.map(m, BookingDto.class)).collect(Collectors.toList());
        return returnBookingHistory;
    }


//    @GetMapping("/mypage/{loginName}")
//    public List<BookingDto> findBookingHistoryList(@PathVariable String loginName) {
//
//        List<BookingHistory> bookingList = bookingHistoryService.findBookingHistoryList(loginName);
//        System.out.println("서비스 : loginId로 예약목록  controller 호출");
//        System.out.println("reviewList : " + bookingList);
//
////        // Review 엔티티를 ReviewDto로 변환
////        List<BookingDto> reviewDtoList = bookingList.stream().map(m-> modelMapper.map(m, BookingDto.class)).collect(Collectors.toList());
//  //      return reviewDtoList;
//        return null;
//    }


    // 예약목록 생성
    @PostMapping(value = "/bookingHistory")
    public BookingDto booking(@RequestBody BookingDto bookingDto) {
    
        BookingHistory bookingHistory = new BookingHistory();
        
        bookingHistory.setBookerId(bookingDto.getBookerId());
        bookingHistory.setBookerName(bookingDto.getBookerName());
        bookingHistory.setBookParkingLotId(bookingDto.getBookParkingLotId());
        bookingHistory.setBokkingParkingLotName(bookingDto.getBokkingParkingLotName());
        //bookingHistory.setBookDate(bookingDto.getBookDate());
        bookingHistory.setBookCarNo(bookingDto.getBookCarNo());

        // 예약 상태
        if (bookingDto.getBookStatus().equals("RESERVED")) {
            bookingHistory.setBookStatus(BookStatus.RESERVED);
        } else {
            bookingHistory.setBookStatus(BookStatus.CANCELED);
        }

        BookingHistory resultBooking = bookingHistoryService.booking(bookingHistory);
        return modelMapper.map(resultBooking, BookingDto.class);

    }
}