package skcc.parkingsk.member.service;

import java.util.List;
import skcc.parkingsk.member.controller.dto.MemberDto;
import skcc.parkingsk.member.domain.entity.Member;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */


public interface MemberService {

  Member login(Member member);

  Member join(Member member);

  List<Member> findAllBlackListMember();

  // Member findMemberById(Long id);

  boolean initPenalty(Member member);

  boolean givePenalty(Member member);

//
//  void testRestTempleteGet(Long id);
//
//  void testRestTempletePost(MemberDto memberDto);
}
