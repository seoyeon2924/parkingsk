package com.skcc.parkingsk.booking.domain.entity;

import com.skcc.parkingsk.booking.domain.vo.AvailableParkingLot;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name="available_parking_lot")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AvailableParkingLotSchedule {

  @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

//  @Embedded
//  @Column(name = "available_parking_lot")
//  private AvailableParkingLot availableParkingLot;
  @Column(name = "available_parking_lot_id")
  private Long availableParkingLotId;
  @Column(name = "available_parking_lot_name")
  private String availableParkingLotName;
  

  @Column(name = "available_capacity")
  private int availableCapacity;

  @Column(name = "book_date")
  private String bookDate;
}
