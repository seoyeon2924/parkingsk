package skcc.parkingsk.member.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import skcc.parkingsk.member.domain.entity.Member;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

public interface MemberRepository extends JpaRepository<Member, Long> {


  //@Query(value = "select m from Member m where m.login.login_id= :loginId", nativeQuery = true)
  List<Member> findByLoginLoginId(String login_id);

}
