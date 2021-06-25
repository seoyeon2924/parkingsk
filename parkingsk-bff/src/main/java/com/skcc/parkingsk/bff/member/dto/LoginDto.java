package com.skcc.parkingsk.bff.member.dto;

import lombok.Data;

/**
 * @author seoyeon on 2021/05/16
 * @project parkingsk
 */

@Data
public class LoginDto {

  private String loginId;

  private String password;

  private String roleType;

  private String name;
}
