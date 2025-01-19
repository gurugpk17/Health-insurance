package Health_insurance.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import Health_insurance.demo.model.Policy;
import Health_insurance.demo.model.PolicyRenewal;
import Health_insurance.demo.dao.PolicyRepo;
import Health_insurance.demo.dao.PolicyRenewalRepo;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepo policyRepository;

    @Autowired
    private PolicyRenewalRepo policyRenewalRepository;

    public void savePolicy(Policy policy) {
        policyRepository.save(policy);
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public void saveRenewal(PolicyRenewal renewal) {
        policyRenewalRepository.save(renewal);
    }
}
