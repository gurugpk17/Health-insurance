package Health_insurance.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public class RelationshipDTO {

    private Long relationshipId;

    @NotNull(message = "Policy ID is required")
    private Long policyId;

    @NotNull(message = "PolicyHolder ID is required")
    private Long policyHolderId;

    @NotBlank(message = "Relationship type is required")
    private String relationshipType;  // e.g., "Primary", "Beneficiary"

    @NotBlank(message = "Person Name is required")
    private String personName;

    private String personGender;
    private LocalDate personDOB;

    // Getters and Setters

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public Long getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(Long policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public LocalDate getPersonDOB() {
        return personDOB;
    }

    public void setPersonDOB(LocalDate personDOB) {
        this.personDOB = personDOB;
    }
}
