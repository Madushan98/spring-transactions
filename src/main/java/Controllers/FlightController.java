package Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import transactions.dto.FlightBookingAcknowledgment;
import transactions.dto.FlightBookingRequest;
import transactions.service.FlightBookingService;

@RestController
@AllArgsConstructor
public class FlightController {

    private FlightBookingService flightBookingService;

    @PostMapping("/bookFlightTicket")
    public FlightBookingAcknowledgment bookingAcknowledgment(FlightBookingRequest request){
        return flightBookingService.bookFlightTicket(request);
    }



}
