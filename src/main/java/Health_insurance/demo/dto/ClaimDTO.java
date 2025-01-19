package Health_insurance.demo.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ClaimDTO {

    private Long claimId;

    @NotNull(message = "Claim Amount cannot be null")
    @Positive(message = "Claim Amount must be positive")
    private double claimAmount;

    @NotNull(message = "Claim Date cannot be null")
    private LocalDateTime claimDate;

    @NotNull(message = "Policy ID is required")
    private Long policyId;

    private String claimStatus;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public LocalDateTime getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDateTime claimDate) {
		this.claimDate = claimDate;
	}

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

}
