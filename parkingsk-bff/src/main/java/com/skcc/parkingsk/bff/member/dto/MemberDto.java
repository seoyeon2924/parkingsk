package com.skcc.parkingsk.bff.member.dto;

import lombok.Data;

/**
 * @author seoyeon on 2021/05/22
 * @project parkingsk
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
