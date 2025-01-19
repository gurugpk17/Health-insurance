package Health_insurance.demo.controller;

import Health_insurance.demo.dto.PolicyHolderDTO;
import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.services.PolicyHolderService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policyholders")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService service;

    // Create a new PolicyHolder
    @PostMapping
    public ResponseEntity<String> createPolicyHolder(@Valid @RequestBody PolicyHolderDTO policyHolderDTO) {
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.setPolicyHolderName(policyHolderDTO.getPolicyHolderName());
        policyHolder.setPolicyHolderDob(policyHolderDTO.getPolicyHolderDob());
        policyHolder.setPolicyHolderGender(policyHolderDTO.getPolicyHolderGender());
        policyHolder.setPolicyHolderAddress(policyHolderDTO.getPolicyHolderAddress());
        policyHolder.setPolicyHolderPhNo(policyHolderDTO.getPolicyHolderPhNo());

        // Save the PolicyHolder using the service
        service.createPolicyHolder(policyHolder);

        return ResponseEntity.ok("Policy Holder created successfully!");
    }

    // Get all PolicyHolders
    @GetMapping
    public List<PolicyHolder> getAllPolicyHolders() {
        return service.getAllPolicyHolders();
    }
}
