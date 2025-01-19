package Health_insurance.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PolicyHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyHolderId;

    private String policyHolderName;
    private LocalDate policyHolderDob;
    private String policyHolderGender;
    private String policyHolderAddress;
    private String policyHolderPhNo;

    // Getters and Setters
    public Long getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(Long policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public LocalDate getPolicyHolderDob() {
        return policyHolderDob;
    }

    public void setPolicyHolderDob(LocalDate policyHolderDob) {
        this.policyHolderDob = policyHolderDob;
    }

    public String getPolicyHolderGender() {
        return policyHolderGender;
    }

    public void setPolicyHolderGender(String policyHolderGender) {
        this.policyHolderGender = policyHolderGender;
    }

    public String getPolicyHolderAddress() {
        return policyHolderAddress;
    }

    public void setPolicyHolderAddress(String policyHolderAddress) {
        this.policyHolderAddress = policyHolderAddress;
    }

    public String getPolicyHolderPhNo() {
        return policyHolderPhNo;
    }

    public void setPolicyHolderPhNo(String policyHolderPhNo) {
        this.policyHolderPhNo = policyHolderPhNo;
    }
}
