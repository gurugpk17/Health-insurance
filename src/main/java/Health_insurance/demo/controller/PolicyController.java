package Health_insurance.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Health_insurance.demo.dto.PolicyDTO;
import Health_insurance.demo.model.Policy;
import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.services.PolicyService;
import Health_insurance.demo.services.PolicyHolderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")  // Base URL for policies
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyHolderService policyHolderService;

    // 1. Create a new policy
    @PostMapping
    public ResponseEntity<String> createPolicy(@Valid @RequestBody PolicyDTO policyDTO) {
        // Convert DTO to Entity
        Policy policy = new Policy();
        policy.setCoverageType(policyDTO.getCoverageType());
        policy.setStartTimeStamp(policyDTO.getStartTimeStamp());
        policy.setEndTimeStamp(policyDTO.getEndTimeStamp());
        policy.setPremiumAmount(policyDTO.getPremiumAmount());

        // Retrieve PolicyHolder using the ID in DTO
        PolicyHolder policyHolder = policyHolderService.getPolicyHolderById(policyDTO.getPolicyHolderId());
        if (policyHolder == null) {
            return ResponseEntity.badRequest().body("Policy Holder not found!");
        }
        policy.setPolicyHolder(policyHolder);

        // Save the Policy
        policyService.savePolicy(policy);

        return ResponseEntity.ok("Policy created successfully!");
    }
}
