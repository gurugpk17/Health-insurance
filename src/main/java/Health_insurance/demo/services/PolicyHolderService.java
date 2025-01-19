package Health_insurance.demo.services;

import Health_insurance.demo.model.*;
import Health_insurance.demo.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHolderService {

    @Autowired
    private PolicyHolderRepo PolicyHolderrepository;

    public PolicyHolder createPolicyHolder(PolicyHolder policyHolder) {
        return PolicyHolderrepository.save(policyHolder);
    }

    public List<PolicyHolder> getAllPolicyHolders() {
        return PolicyHolderrepository.findAll();
    }

    public PolicyHolder getPolicyHolderById(Long policyHolderId) {
        // Find PolicyHolder by ID, return null if not found
        Optional<PolicyHolder> policyHolder = PolicyHolderrepository.findById(policyHolderId);
        return policyHolder.orElse(null);  // Return null if not found
    }
}
