package skcc.parkingsk.member.domain.entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class FavorateParkingLot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  private Long parkingLotId;
  private String parkingLotName;

}
