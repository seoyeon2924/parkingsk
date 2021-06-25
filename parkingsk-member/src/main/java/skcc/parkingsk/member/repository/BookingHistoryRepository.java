package skcc.parkingsk.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skcc.parkingsk.member.domain.entity.BookingHistory;

import java.util.List;

/**
 * @author seoyeon on 2021/05/11
 * @project skparking
 */

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory,Long> {

    @Query("select b from BookingHistory b where b.bookerName = :name")
    List<BookingHistory> findBoookingHistoryList(@Param("name") String name);


}
