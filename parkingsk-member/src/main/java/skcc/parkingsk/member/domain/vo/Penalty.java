package skcc.parkingsk.member.domain.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Penalty {
	private Date penaltyDate;
	private String parkingLotName;
	private Long parkingLotId;
	private String penaltyReason;
}
