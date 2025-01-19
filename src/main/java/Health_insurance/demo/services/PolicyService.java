package Health_insurance.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Health_insurance.demo.model.Claim;
import Health_insurance.demo.model.Policy;
import Health_insurance.demo.model.PolicyRenewal;
import Health_insurance.demo.model.Relationship;
import Health_insurance.demo.dao.PolicyRepo;
import Health_insurance.demo.dao.ClaimRepo;
import Health_insurance.demo.dao.PolicyRenewalRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepo policyRepository;

    @Autowired
    private PolicyRenewalRepo policyRenewalRepository;

    @Autowired
    private ClaimRepo policyClaimRepository;

    public void savePolicy(Policy policy) {
        policyRepository.save(policy);
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);  // If policy not found, it returns null
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public void saveRenewal(PolicyRenewal renewal) {
        policyRenewalRepository.save(renewal);
    }

    // Claims

    public Claim createClaimForPolicy(Long policyId, Long personId, Claim claim) {
        Policy policy = getPolicyById(policyId);
        if (policy == null) {
            throw new IllegalArgumentException("Policy not found with ID " + policyId);
        }

        // Find the specific relationship (person) for this policy holder
        Optional<Relationship> relationshipOptional = policy.getPolicyHolder()
                                                              .getRelationships()
                                                              .stream()
                                                              .filter(r -> r.getPersonId().equals(personId))  // Use getPersonId() instead
                                                              .findFirst();
        
        if (!relationshipOptional.isPresent()) {
            throw new IllegalArgumentException("Relationship not found for the given ID");
        }

        // Set the relationship in the claim
        claim.setRelationship(relationshipOptional.get());
        return policyClaimRepository.save(claim);
    }

    // Get all Claims for a specific Policy
    public List<Claim> getClaimsByPolicyId(Long policyId) {
        Policy policy = getPolicyById(policyId);
        if (policy == null) {
            throw new IllegalArgumentException("Policy not found with ID " + policyId);
        }

        return policyClaimRepository.findByRelationship_PersonId(policyId);  // Assuming findByPolicyId exists in the repository
    }
}
