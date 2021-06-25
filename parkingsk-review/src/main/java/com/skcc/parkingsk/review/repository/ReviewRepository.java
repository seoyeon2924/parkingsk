package com.skcc.parkingsk.review.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skcc.parkingsk.review.controller.dto.ReviewDto;
import com.skcc.parkingsk.review.domain.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	@Query("select r from Review r where r.parkingLotId = :parkingLotId")
	List<Review> findByParkingLotId(@Param("parkingLotId") Long parkingLotId);
	
	

}
