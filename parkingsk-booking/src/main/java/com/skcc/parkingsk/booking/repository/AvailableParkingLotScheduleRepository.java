package com.skcc.parkingsk.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skcc.parkingsk.booking.domain.entity.AvailableParkingLotSchedule;


public interface AvailableParkingLotScheduleRepository extends JpaRepository<AvailableParkingLotSchedule, Long> {
  AvailableParkingLotSchedule findAvailableParkingLotScheduleById(Long id);
//  @Query("select availableCapacity from available_parking_lot where available_parking_lot_id = ? and book_date = ?")
//  int findAvailableCapacityByBookDate(AvailableParkingLotSchedule availableParkingLotSchedule);
  @Query(value = "select available_capacity from available_parking_lot r where r.available_parking_lot_id = :availableParkingLotId and r.book_date = :bookDate", nativeQuery = true)
  int getAvailableCapacity(@Param("bookDate")String bookDate, @Param("availableParkingLotId")Long availableParkingLotId);
}
