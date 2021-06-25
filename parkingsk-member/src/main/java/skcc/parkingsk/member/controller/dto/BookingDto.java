package skcc.parkingsk.member.controller.dto;

import java.util.Date;
import lombok.Data;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */
@Data
public class BookingDto {


  private Long id;

  private String bookerId;

  private String bookerName;

  private String bookParkingLotId;

  private String bokkingParkingLotName;

  private String bookDate;

  private String bookCarNo;

  private String bookStatus;
}
