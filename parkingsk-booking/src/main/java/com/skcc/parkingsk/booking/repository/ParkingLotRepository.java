package com.skcc.parkingsk.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.parkingsk.booking.domain.entity.ParkingLot;


@Repository
@Transactional
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>  {

    @Query(value="SELECT * FROM parking_lot r WHERE r.id = :parkingLotId", nativeQuery = true)
    ParkingLot findByParkingLotId(@Param("parkingLotId") Long parkingLotId);

    public List<ParkingLot> findByNameContainingIgnoreCase(String parkingLotName);
}


