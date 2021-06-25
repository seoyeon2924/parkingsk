package com.skcc.parkingsk.bff.member.dto;

import java.util.Date;
import lombok.Data;

/**
 * @author seoyeon on 2021/05/23
 * @project parkingsk
 */

@Data
public class BookingHistoryDto {

  private Long id;

  private String bookerId;

  private String bookerName;

  private String bookParkingLotId;

  private String bokkingParkingLotName;

  private String bookDate;

  private String bookCarNo;

  private String bookStatus;

}
