package com.skcc.parkingsk.booking.domain.vo;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author seoyeon on 2021/05/07
 * @project parkingsk.member
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable //참조하고 있는곳에 임베디드 된다.
public class BookParkingLot {

  private Long parkingLotId;
  private String parkingLotName;
}
