package com.skcc.parkingsk.booking.domain.entity;

import com.skcc.parkingsk.booking.domain.enums.BookStatus;
//import com.skcc.parkingsk.booking.domain.vo.BookParkingLot;
//import com.skcc.parkingsk.booking.domain.vo.Booker;
//import java.util.Date;
import javax.persistence.Column;
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

/**
 * @author seoyeon on 2021/05/07
 * @project parkingsk.member
 */

@Entity
@Table(name="booking")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Booking {

  @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Long id;

//  @Embedded
//  @Column(name="booker")
//  private Booker booker;
  @Column(name="booker_id")
  private String bookerId;
  @Column(name="booker_name")
  private String bookerName;
  

//  @Embedded
//  @Column(name="booking_parking_lot")
//  private BookParkingLot bookParkingLot;
	@Column(name="parking_lot_id")
    private Long parkingLotId;
	@Column(name="parking_lot_name")
    private String parkingLotName;
  

  @Column(name="book_date")
  private String bookdate;

  @Column(name="book_car_no")
  private String bookCarNo;

  @Enumerated(EnumType.STRING) // Ordinal 은 0번,1번으로 값이 들어가서 스트링 참조하려면 꼭 EmnumType.STRING 써줘야
  @Column(name="book_status")
  private BookStatus bookStatus;
}
