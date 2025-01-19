package Health_insurance.demo.dao;

import Health_insurance.demo.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepo extends JpaRepository<Claim, Long> {
	    List<Claim> findByRelationship_PersonId(Long personId); // Access personId via the Relationship

}
