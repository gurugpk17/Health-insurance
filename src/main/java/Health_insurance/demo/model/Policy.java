package Health_insurance.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;

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

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	private String coverageType;
    private LocalDateTime startTimeStamp;
    private LocalDateTime endTimeStamp;
    private double premiumAmount;

    @ManyToOne
    @JoinColumn(name = "policyHolderId", nullable = false)
    private PolicyHolder policyHolder;


}
