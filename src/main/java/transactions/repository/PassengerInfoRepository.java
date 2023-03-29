package transactions.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import transactions.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}
