package Health_insurance.demo.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

public class RenewalDTO {

    private Long renewalId;

    @NotNull(message = "Renewal Date cannot be null")
    private LocalDateTime renewalTimeStamp;

    @NotNull(message = "Policy ID is required")
    private Long policyId;

    @NotNull(message = "Renewal Premium cannot be null")
    @Positive(message = "Renewal Premium must be positive")
    private double renewalPremium;

    public Long getRenewalId() {
        return renewalId;
    }

    public void setRenewalId(Long renewalId) {
        this.renewalId = renewalId;
    }

    public LocalDateTime getRenewalTimeStamp() {
        return renewalTimeStamp;
    }

    public void setRenewalTimeStamp(LocalDateTime renewalTimeStamp) {
        this.renewalTimeStamp = renewalTimeStamp;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public double getRenewalPremium() {
        return renewalPremium;
    }

    public void setRenewalPremium(double renewalPremium) {
        this.renewalPremium = renewalPremium;
    }
}
