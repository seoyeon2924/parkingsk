package skcc.parkingsk.member.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberStatus {
	ACTIVE,
	LOCK,
	DELETED
}
