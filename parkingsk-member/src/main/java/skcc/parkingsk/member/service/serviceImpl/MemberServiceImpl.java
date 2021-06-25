package skcc.parkingsk.member.service.serviceImpl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import skcc.parkingsk.member.controller.dto.MemberDto;
import skcc.parkingsk.member.domain.entity.Member;
import skcc.parkingsk.member.repository.MemberRepository;
import skcc.parkingsk.member.service.MemberService;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;
 // private final RestTemplate restTemplate;

  @Override
  public Member login(Member member) {
    System.out.println("member.getLogin().getLoginId() : " + member.getLogin().getLoginId());
    List<Member> byLoginId = memberRepository.findByLoginLoginId(member.getLogin().getLoginId());
    if (byLoginId.get(0).getLogin().getLoginPassword()
        .equals(member.getLogin().getLoginPassword())) {
      return byLoginId.get(0);
    } else {
      return null;
    }
  }

  @Override
  public Member join(Member member) {
    System.out.println("서비스 단의 member: "+ member);
    Member savedMember = memberRepository.save(member);
    return savedMember;
  }

  @Override
  public List<Member> findAllBlackListMember() {
    return null;
  }

  @Override
  public boolean initPenalty(Member member) {
    return false;
  }

  @Override
  public boolean givePenalty(Member member) {
    return false;
  }


//  @Override
//  public void testRestTempleteGet(Long id) {
//    MemberDto returnMemberDto = this.restTemplate
//        .getForObject(String.format("%s%s%d", "http://localhost:8081", "/testRestTempleteGet/", id),
//            MemberDto.class);
//
//    System.out.println(returnMemberDto.getLoginId());
//    System.out.println(returnMemberDto.getName());
//  }
//
//
//  @Override
//  public void testRestTempletePost(MemberDto memberDto) {
//    // 자 나는 BFF야, MSA에게 포스트 매핑을 던져보자
//
//    memberDto.setName("안서연BFF이름");
//    memberDto.setLoginId("안서연BFF로그인아이디");
//    MemberDto returnMemberDto = this.restTemplate
//        .postForObject(String.format("%s%s", "http://localhost:8081", "/testRestTempletePost"),
//            memberDto, MemberDto.class);
//
//    System.out.println(returnMemberDto.getName());
//    System.out.println(returnMemberDto.getLoginId());
//
//  }
}
