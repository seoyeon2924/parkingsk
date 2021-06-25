package com.skcc.parkingsk.bff.member.controller;

import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MemberController {

  // private static final Logger log = (Logger) LoggerFactory.getLogger(MemberController.class);

  //1. 로그인
  @GetMapping("/login")
  public String login(HttpSession session, Model model) {
    if (session.getAttribute("loginId") != null) {
      session.removeAttribute("loginId");
      //session.getAttribute().rem("loginId");
    }
    return "login";
  }

  //2. 회원가입
  @GetMapping("/register")
  public String register(HttpSession session, Model model) {
    if (session.getAttribute("loginId") != null) {
      session.removeAttribute("loginId");
    }
    return "register";
  }

  //3. 마이페이지
  @GetMapping("/mypage")
  public String mypage(HttpSession session, Model model) {

    if (session.getAttribute("loginId") == null) {
      return "login";
    }
    model.addAttribute("loginId", session.getAttribute("loginId"));
    return "mypage";
  }


  //3.블랙 리스트 조회

  //4.특정회원의 경고횟수 조히인데.. 이건잠시 보류

  //5.경고횟수 초기화

  //6.경고주기

  //7.좋아요 목록 추가

  //8.좋아요 취소




}
