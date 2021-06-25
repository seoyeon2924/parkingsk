package skcc.parkingsk.member.controller.dto;

import lombok.Data;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */
@Data
public class MemberDto {

  private String loginId;

  private String loginPassword;

  private String company;

  private String employeeNumber;

  private String name;

  private String roleType;

  private String memberStatus;
}
