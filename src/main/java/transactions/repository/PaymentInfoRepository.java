package transactions.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import transactions.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo,String> {
}
