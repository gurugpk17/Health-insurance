package Health_insurance.demo.dao;

import Health_insurance.demo.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepo extends JpaRepository<Policy, Long> {
    // JpaRepository provides methods like save(), findById(), findAll(), deleteById()
}
