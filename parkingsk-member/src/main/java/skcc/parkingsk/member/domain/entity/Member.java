package skcc.parkingsk.member.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import skcc.parkingsk.member.domain.enums.MemberStatus;
import skcc.parkingsk.member.domain.enums.RoleType;
import skcc.parkingsk.member.domain.vo.Login;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

  @Id
  @Column(name = "member_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long memberId;

  @Column(name = "company")
  private String company;

  @Column(name = "employee_number")
  private String employeeNumber;

  @Column(name = "name")
  private String name;

  @Column(name = "login")
  @Embedded
  private Login login;

  @Column(name = "role_type")
  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  @Column(name = "member_status")
  @Enumerated(EnumType.STRING)
  private MemberStatus memberStatus;

  @Column(name = "panelty_count")
  @ColumnDefault("0")
  private Integer paneltyCount;

}
