package Health_insurance.demo.services;

import Health_insurance.demo.model.PolicyHolder;
import Health_insurance.demo.model.Relationship;
import Health_insurance.demo.dao.PolicyHolderRepo;
import Health_insurance.demo.dao.RelationshipRepo;
import Health_insurance.demo.dto.RelationshipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHolderService {

    @Autowired
    private PolicyHolderRepo policyHolderRepository;

    @Autowired
    private RelationshipRepo relationshipRepository;

    // Create a new PolicyHolder
    public PolicyHolder createPolicyHolder(PolicyHolder policyHolder) {
        return policyHolderRepository.save(policyHolder);
    }

    // Get all PolicyHolders
    public List<PolicyHolder> getAllPolicyHolders() {
        return policyHolderRepository.findAll();
    }

    // Get a PolicyHolder by ID
    public PolicyHolder getPolicyHolderById(Long policyHolderId) {
        Optional<PolicyHolder> policyHolder = policyHolderRepository.findById(policyHolderId);
        if (policyHolder.isPresent()) {
            return policyHolder.get();
        } else {
            throw new IllegalArgumentException("PolicyHolder not found with ID: " + policyHolderId);
        }
    }

    // Update a PolicyHolder by ID
    public PolicyHolder updatePolicyHolder(Long policyHolderId, PolicyHolder updatedPolicyHolder) {
        Optional<PolicyHolder> existingPolicyHolder = policyHolderRepository.findById(policyHolderId);
        if (existingPolicyHolder.isPresent()) {
            updatedPolicyHolder.setPolicyHolderId(policyHolderId);  // Ensure the ID is preserved
            return policyHolderRepository.save(updatedPolicyHolder);
        } else {
            throw new IllegalArgumentException("PolicyHolder not found with ID: " + policyHolderId);
        }
    }

    // Delete a PolicyHolder by ID
    public boolean deletePolicyHolder(Long policyHolderId) {
        Optional<PolicyHolder> policyHolder = policyHolderRepository.findById(policyHolderId);
        if (policyHolder.isPresent()) {
            policyHolderRepository.delete(policyHolder.get());
            return true;
        }
        return false;  // Return false if not found
    }

    // Add Relationship to PolicyHolder
    public Relationship addRelationshipToPolicyHolder(Long policyHolderId, RelationshipDTO relationshipDTO) {
        // Find the PolicyHolder by ID
        Optional<PolicyHolder> policyHolderOptional = policyHolderRepository.findById(policyHolderId);
        if (!policyHolderOptional.isPresent()) {
            throw new IllegalArgumentException("PolicyHolder not found with ID: " + policyHolderId);
        }

        // Map DTO to Relationship
        Relationship relationship = new Relationship();
        relationship.setPersonRelation(relationshipDTO.getRelationshipType());
        relationship.setPolicyHolder(policyHolderOptional.get()); // Set the PolicyHolder

        // Save the relationship
        return relationshipRepository.save(relationship);
    }

    // Get all Relationships for a PolicyHolder
    public List<Relationship> getAllRelationshipsForPolicyHolder(Long policyHolderId) {
        Optional<PolicyHolder> policyHolderOptional = policyHolderRepository.findById(policyHolderId);
        if (!policyHolderOptional.isPresent()) {
            throw new IllegalArgumentException("PolicyHolder not found with ID: " + policyHolderId);
        }
        return policyHolderOptional.get().getRelationships(); // Assuming the relationships are mapped in PolicyHolder model
    }
}
