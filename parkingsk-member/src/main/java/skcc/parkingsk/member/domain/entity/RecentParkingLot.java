package skcc.parkingsk.member.domain.entity;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import skcc.parkingsk.member.domain.entity.Member;

@Data
@NoArgsConstructor
@Embeddable
public class RecentParkingLot {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne
	@JoinColumn(name ="member_id")
	private Member member;

	private Long parkingLotId;
	private String parkingLotName;
}
