package com.skcc.parkingsk.bff.member.service;

import com.skcc.parkingsk.bff.member.dto.BookingHistoryDto;
import com.skcc.parkingsk.bff.member.dto.LoginDto;
import com.skcc.parkingsk.bff.member.dto.MemberDto;
import com.skcc.parkingsk.bff.review.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

  private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);
  private final RestTemplate restTemplate;

  @Value("${api.member.url}")
  private String apiGatewayUrl;

  public LoginDto login(LoginDto loginDto) {
    return this.restTemplate
        .postForObject(String.format("%s%s", apiGatewayUrl, "/login"),
            loginDto, LoginDto.class);
  }

  public MemberDto register(MemberDto memberDto) {
    return this.restTemplate
        .postForObject(String.format("%s%s", apiGatewayUrl, "/join"), memberDto,
            MemberDto.class);

  }

  public List<BookingHistoryDto> searchMypage(Object name) {
    BookingHistoryDto[] resultClasses = restTemplate.getForObject(String.format("%s%s%s", apiGatewayUrl, "mypage/", name), BookingHistoryDto[].class);
    for (BookingHistoryDto bookingHistoryDto : resultClasses) {
    }
    return Arrays.asList(resultClasses);

  }



/*
  public List searchMypage(String loginId) {
    return this.restTemplate.postForObject(String.format("%s%s",apiGatewayUrl,"searchMypage"),loginId,
        java.awt.List.class);
  }*/
}
