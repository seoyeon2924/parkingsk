package com.skcc.parkingsk.booking.repository;

//import com.skcc.parkingsk.booking.domain.dto.BookingDto;
import com.skcc.parkingsk.booking.domain.entity.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking,Long> {
	 @Query(value="SELECT r FROM booking r WHERE r.id = :bookId", nativeQuery = true)
	 Booking findByBookingId(@Param("bookId") Long bookId);	 
	
//	 List<Booking> findAllByBooker_BookerId(Long bookerId);
	 List<Booking> findAllByBookerId(Long bookerId);
	
	 @Query(value="SELECT count(*) FROM booking r WHERE r.booker_id = :bookerId AND r.book_date = :bookDate AND r.book_car_no = :bookCarNo", nativeQuery = true)
	 int selectBookingInfo(@Param("bookDate")String bookDate, @Param("bookCarNo")String bookCarNo, @Param("bookerId")String bookerId);

//	 String save(Booking bookingDto);

}
