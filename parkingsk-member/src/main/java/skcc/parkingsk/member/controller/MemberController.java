package skcc.parkingsk.member.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import skcc.parkingsk.member.controller.dto.LoginDto;
import skcc.parkingsk.member.controller.dto.MemberDto;
import skcc.parkingsk.member.domain.entity.Member;
import skcc.parkingsk.member.domain.enums.MemberStatus;
import skcc.parkingsk.member.domain.enums.RoleType;
import skcc.parkingsk.member.domain.vo.Login;
import skcc.parkingsk.member.kafka.MessageSender;
import skcc.parkingsk.member.service.MemberService;


/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

@RestController
@RequiredArgsConstructor
public class MemberController {


  private final MemberService memberService;

  private final ModelMapper modelMapper;

  private final MessageSender producer;

  //1. 로그인
  @PostMapping(value = "/login")
  public LoginDto login(@RequestBody LoginDto loginDto) {
    //memberDto -> Member
    //Member member = modelMapper.map(memberDto, Member.class);

    Member member = new Member();
    Login login = new Login();
    login.setLoginId(loginDto.getLoginId());
    login.setLoginPassword(loginDto.getPassword());

    member.setLogin(login);

    System.out.println(member.getLogin().getLoginId());
    Member resultMember = memberService.login(member);

    System.out.println("resultMember : " + resultMember);
    //Member -> MemberDto
    return modelMapper.map(resultMember, LoginDto.class);
  }


  //2.회원가입
  @PostMapping(value = "/join")
  public MemberDto join(@RequestBody MemberDto memberDto) {
    //Member member = modelMapper.map(memberDto, Member.class);

    Member member = new Member();
    member.setLogin(new Login(memberDto.getLoginId(), memberDto.getLoginPassword()));
    member.setCompany(memberDto.getCompany());
    member.setEmployeeNumber(memberDto.getEmployeeNumber());
    member.setName(memberDto.getName());
    member.setMemberStatus(MemberStatus.ACTIVE);
    if (memberDto.getRoleType().equals("사용자")) {
      member.setRoleType(RoleType.USER);
    } else {
      member.setRoleType(RoleType.ADMIN);
    }
    Member joinedMember = memberService.join(member);

    return modelMapper.map(joinedMember, MemberDto.class);
  }

  //3.블랙리스트 목록 조회

  //4.특정회원의 경고횟수 조히인데.. 이건잠시 보류

  //5.경고횟수 초기화

  //6.경고주기

  //7.좋아요 목록 추가

  //8.좋아요 취소

  //9.최근예약 주차장 등록


}

//
//  //카프카테스트
//  @GetMapping(value = "/kafkaTest")
//  public void kafkatest() {
//    MemberDto memberDto = new MemberDto();
//    memberDto.setName("안서연");
//    /*
//     * 비동기로 전달할 데이터 셋팅
//     * */
//    producer.send(memberDto); // 이벤트 발행
//  }
//
//  //BFF ##Get 버전 테스트
//  @GetMapping(value = "/testRestTempleteGet/{id}")
//  public void testRestTempleteGet(@PathVariable Long id) {
//    System.out.println(String.format("%s%s%d", "http://localhost:8081", "/testRestTemplete/", id));
//
//    memberService.testRestTempleteGet(id);
//  }
//
//  //BFF ##Post 버전 테스트
//  @PostMapping(value = "/testRestTempletePost")
//  public MemberDto testRestTempletePost(@RequestBody MemberDto memberDto) {
//
//    //memberDto를 Member로 바꾸기(뭐.. 각자 필요하면 수행 할까?
//    // Member member = modelMapper.map(memberDto, Member.class);
//    // Member resultMember = memberService.login(member);
//
//    memberService.testRestTempletePost(memberDto);
//    return null;
//    //modelMapper.map(resultMember, MemberDto.class);
// }
//
//  @PostMapping(value = "/testRestTemplete")
//  public MemberDto login(@RequestBody MemberDto memberDto) {
//    //memberDto를 Member로 바꾸기
//    // Member member = modelMapper.map(memberDto, Member.class);
//    // Member resultMember = memberService.login(member);
//    return null;
//    //modelMapper.map(resultMember, MemberDto.class);
//  }