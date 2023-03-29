package transactions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import transactions.entity.PassengerInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgment {

    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;

}
