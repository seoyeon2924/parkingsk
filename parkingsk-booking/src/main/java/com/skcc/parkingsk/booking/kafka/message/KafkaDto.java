package com.skcc.parkingsk.booking.kafka.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author seoyeon on 2021/05/14
 * @project skparking
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KafkaDto {

	private Long  id;
    private String name;
    private int capacity;
    private String parkingLotStatus;
}
