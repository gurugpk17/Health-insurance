package Health_insurance.demo.dto;

import jakarta.validation.constraints.*;

public class RelationshipDTO {

    private Long relationshipId;

    @NotNull(message = "Policy ID is required")
    private Long policyId;

    @NotNull(message = "PolicyHolder ID is required")
    private Long policyHolderId;

    private String relationshipType;  // e.g., "Primary", "Beneficiary"

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

}
