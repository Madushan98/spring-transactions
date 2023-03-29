package transactions.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transactions.dto.FlightBookingAcknowledgment;
import transactions.dto.FlightBookingRequest;
import transactions.entity.PassengerInfo;
import transactions.entity.PaymentInfo;
import transactions.repository.PassengerInfoRepository;
import transactions.repository.PaymentInfoRepository;
import transactions.utills.PaymentUtils;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightBookingService {
    private PassengerInfoRepository passengerInfoRepository;
    private PaymentInfoRepository paymentInfoRepository;
    @Transactional
    public FlightBookingAcknowledgment bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgment("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
