package com.skcc.parkingsk.bff.member.controller;

import com.skcc.parkingsk.bff.member.dto.BookingHistoryDto;
import com.skcc.parkingsk.bff.member.dto.LoginDto;
import com.skcc.parkingsk.bff.member.dto.MemberDto;
import com.skcc.parkingsk.bff.member.service.MemberService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.skcc.parkingsk.bff.parkinglot.dto.ParkingLotDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author seoyeon on 2021/05/15
 * @project parkingsk
 */

@RestController
@RequiredArgsConstructor
public class MemberRestController {

  private static final Logger log = LoggerFactory.getLogger(MemberController.class);
  private final MemberService memberService;


  //1. 로그인
  @PostMapping(value = "login")
  public ResponseEntity<LoginDto> login(HttpSession session, @RequestBody LoginDto loginDto)
      throws Exception {

    System.out.println(" login rest loginDto!!!!" + loginDto);
    LoginDto login = this.memberService.login(loginDto);
    if (login.getLoginId() != null) {
      session.setAttribute("loginId", login.getLoginId());
      session.setAttribute("loginName", login.getName());
    } else {
      throw new Exception();
    }
    return new ResponseEntity<LoginDto>(login, HttpStatus.OK);
  }

  //2. 회원가입
  @PostMapping(value = "register")
  public ResponseEntity<MemberDto> register(HttpSession session, @RequestBody MemberDto memberDto) {

    return new ResponseEntity<MemberDto>(memberService.register(memberDto), HttpStatus.OK);
  }

  //3. 마이페이지
  @PostMapping(value = "mypage")
  public ResponseEntity<List<BookingHistoryDto>> searchMypage(HttpSession session) {

    System.out.println(" mypage rest loginId!!!!" + (session.getAttribute("loginId") ));
    System.out.println(" mypage rest loginName!!!!" + (session.getAttribute("loginName") ));
    List<BookingHistoryDto> result = memberService.searchMypage(session.getAttribute("loginName"));
    return ResponseEntity.ok().body(result);
  }

  //@PostMapping(value = "mypage")
//  public ResponseEntity<List<BookingHistoryDto>> searchMypage2(HttpSession session) {
//
//    List<BookingHistoryDto> result = new ArrayList<>();
//
//    BookingHistoryDto bookingHistoryDto1 = new BookingHistoryDto();
//    bookingHistoryDto1.setBookCarNo("35서8749");
//    bookingHistoryDto1.setBookerName("안서연");
//
//    result.add(bookingHistoryDto1);
//
//    BookingHistoryDto bookingHistoryDto2 = new BookingHistoryDto();
//    bookingHistoryDto2.setBookCarNo("323두2713");
//    bookingHistoryDto2.setBookerName("문성인");
//
//    result.add(bookingHistoryDto2);
//
//    // memberService.searchMypage(session.getAttribute("loginId"));
//
//    return ResponseEntity.ok().body(result);
//  }

}
