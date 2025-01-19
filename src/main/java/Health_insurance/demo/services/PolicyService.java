package Health_insurance.demo.services;

import Health_insurance.demo.model.Policy;
import Health_insurance.demo.dao.PolicyRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepo policyRepo;

    // Save a policy
    public Policy savePolicy(Policy policy) {
        return policyRepo.save(policy);
    }

    // Fetch all policies
    public List<Policy> getAllPolicies() {
        return policyRepo.findAll();
    }

    // Find a policy by ID
    public Policy getPolicyById(Long id) {
        return policyRepo.findById(id).orElse(null);
    }
}
