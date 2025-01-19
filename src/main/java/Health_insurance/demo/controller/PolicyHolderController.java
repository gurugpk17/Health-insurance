package Health_insurance.demo.controller;

import Health_insurance.demo.dto.PolicyHolderDTO;
import Health_insurance.demo.dto.RelationshipDTO;
import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.model.Relationship;
import Health_insurance.demo.services.PolicyHolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policyholders")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService policyHolderService;

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
        policyHolderService.createPolicyHolder(policyHolder);

        return ResponseEntity.ok("Policy Holder created successfully!");
    }

    // Get all PolicyHolders
    @GetMapping
    public List<PolicyHolder> getAllPolicyHolders() {
        return policyHolderService.getAllPolicyHolders();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getPolicyHolderById(@PathVariable Long id) {
        PolicyHolder policyHolder = policyHolderService.getPolicyHolderById(id);
        if (policyHolder == null) {
            return ResponseEntity.status(404).body("PolicyHolder not found with ID " + id);
        }
        return ResponseEntity.ok(policyHolder);
    }
    
    
    // Add a Relationship to a PolicyHolder
    @PostMapping("/{policyHolderId}/relationships")
    public ResponseEntity<Relationship> addRelationship(
            @PathVariable("policyHolderId") Long policyHolderId,
            @RequestBody @Validated RelationshipDTO relationshipDTO) {
        try {
            Relationship relationship = policyHolderService.addRelationshipToPolicyHolder(policyHolderId, relationshipDTO);
            return new ResponseEntity<>(relationship, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all Relationships of a specific PolicyHolder
    @GetMapping("/{policyHolderId}/relationships")
    public ResponseEntity<List<Relationship>> getAllRelationshipsForPolicyHolder(
            @PathVariable("policyHolderId") Long policyHolderId) {
        List<Relationship> relationships = policyHolderService.getAllRelationshipsForPolicyHolder(policyHolderId);
        return new ResponseEntity<>(relationships, HttpStatus.OK);
    }

    // Update an existing PolicyHolder
    @PutMapping("/{id}")
    public ResponseEntity<PolicyHolder> updatePolicyHolder(
            @PathVariable("id") Long id, @RequestBody @Validated PolicyHolder policyHolder) {
        PolicyHolder updatedPolicyHolder = policyHolderService.updatePolicyHolder(id, policyHolder);
        if (updatedPolicyHolder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedPolicyHolder, HttpStatus.OK);
    }

    // Delete a PolicyHolder
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicyHolder(@PathVariable("id") Long id) {
        if (policyHolderService.deletePolicyHolder(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
