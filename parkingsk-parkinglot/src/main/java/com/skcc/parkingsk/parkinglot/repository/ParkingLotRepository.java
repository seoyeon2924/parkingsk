package com.skcc.parkingsk.parkinglot.repository;

import com.skcc.parkingsk.parkinglot.domain.entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long>  {

    @Query("SELECT r FROM ParkingLot r WHERE r.id = :parkingLotId")
    ParkingLot findByParkingLotId(@Param("parkingLotId") Long parkingLotId);

    public List<ParkingLot> findByNameContainingIgnoreCase(String parkingLotName);
}


