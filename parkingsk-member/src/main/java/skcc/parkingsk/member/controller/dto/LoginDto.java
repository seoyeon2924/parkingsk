package skcc.parkingsk.member.controller.dto;

import lombok.Data;

/**
 * @author seoyeon on 2021/05/17
 * @project parkingsk
 */

@Data
public class LoginDto {

  private String loginId;
  private String password;
  private String roleType;
  private String name;
}
