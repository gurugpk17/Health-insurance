package Health_insurance.demo.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PolicyDTO {

    private Long policyId;  // Optional: For updates only

    @NotNull(message = "Coverage type cannot be null")
    private String coverageType;

    @NotNull(message = "Start timestamp cannot be null")
    private LocalDateTime startTimeStamp;

    @NotNull(message = "End timestamp cannot be null")
    private LocalDateTime endTimeStamp;

    @NotNull(message = "Premium amount cannot be null")
    private Double premiumAmount;

    @NotNull(message = "Policy Holder ID cannot be null")
    private Long policyHolderId;  // Reference to PolicyHolder

    // Getters and setters
    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public LocalDateTime getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(LocalDateTime startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public LocalDateTime getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(LocalDateTime endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public Long getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(Long policyHolderId) {
        this.policyHolderId = policyHolderId;
    }
}
