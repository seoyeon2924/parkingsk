package skcc.parkingsk.member.kafka.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BookingKafkaDto {

    private String bookerId;

    private String bookerName;

    private String parkingLotId;

    private String parkingLotName;

    private Date bookdate;

    private String bookCarNo;

    private String bookStatus;
}

