package Health_insurance.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Health_insurance.demo.dto.PolicyDTO;
import Health_insurance.demo.dto.RenewalDTO;
import Health_insurance.demo.model.Policy;
import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.model.PolicyRenewal;
import Health_insurance.demo.services.PolicyService;
import Health_insurance.demo.services.PolicyHolderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private PolicyHolderService policyHolderService;

    // 1. Create a new policy
    @PostMapping
    public ResponseEntity<String> createPolicy(@Valid @RequestBody PolicyDTO policyDTO) {
        Policy policy = new Policy();
        policy.setCoverageType(policyDTO.getCoverageType());
        policy.setStartTimeStamp(policyDTO.getStartTimeStamp());
        policy.setEndTimeStamp(policyDTO.getEndTimeStamp());
        policy.setPremiumAmount(policyDTO.getPremiumAmount());

        PolicyHolder policyHolder = policyHolderService.getPolicyHolderById(policyDTO.getPolicyHolderId());
        if (policyHolder == null) {
            return ResponseEntity.badRequest().body("Policy Holder not found!");
        }
        policy.setPolicyHolder(policyHolder);

        policyService.savePolicy(policy);
        return ResponseEntity.ok("Policy created successfully!");
    }

    // 2. Get all policies
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    // 3. Get a policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPolicyById(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return ResponseEntity.status(404).body("Policy not found with ID " + id);
        }
        return ResponseEntity.ok(policy);
    }

    // 4. Create a renewal for a policy
    @PostMapping("/{policyId}/renewal")
    public ResponseEntity<String> createRenewal(@PathVariable Long policyId, @Valid @RequestBody RenewalDTO renewalDTO) {
        Policy policy = policyService.getPolicyById(policyId);
        if (policy == null) {
            return ResponseEntity.badRequest().body("Policy not found!");
        }

        PolicyRenewal renewal = new PolicyRenewal();
        renewal.setRenewalTimeStamp(renewalDTO.getRenewalTimeStamp());
        renewal.setRenewalStatus("PENDING");  // Default status
        renewal.setPolicy(policy);

        policyService.saveRenewal(renewal);
        return ResponseEntity.ok("Renewal created successfully for Policy ID " + policyId);
    }
}
