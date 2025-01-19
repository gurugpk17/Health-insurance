package Health_insurance.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public LocalDateTime getClaimTimeStamp() {
		return claimTimeStamp;
	}

	public void setClaimTimeStamp(LocalDateTime claimTimeStamp) {
		this.claimTimeStamp = claimTimeStamp;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	private LocalDateTime claimTimeStamp;
    private double claimAmount;
    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private Relationship relationship;

}
