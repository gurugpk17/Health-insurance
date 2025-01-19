package Health_insurance.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class PolicyRenewal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long renewalId;

    @CreationTimestamp
    private LocalDateTime renewalTimeStamp;

    private String renewalStatus = "PENDING";  // Default value for status

    @ManyToOne
    @JoinColumn(name = "policyId", nullable = false)
    private Policy policy;

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

    public String getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(String renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
