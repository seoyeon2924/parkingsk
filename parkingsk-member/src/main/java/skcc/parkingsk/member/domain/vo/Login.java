package skcc.parkingsk.member.domain.vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Login {

  @Column(name = "login_id")
  private String loginId;

  @Column(name = "login_password")
  private String loginPassword;
  @Column(name = "last_login_date")
  private Date lastLoginDate;

  public Login(String loginId, String loginPassword) {
    this.loginId = loginId;
    this.loginPassword = loginPassword;
  }
}
