package Health_insurance.demo.dao;

import Health_insurance.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRenewalRepo extends JpaRepository<PolicyRenewal, Long> {
}
