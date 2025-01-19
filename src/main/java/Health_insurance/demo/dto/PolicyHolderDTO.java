package Health_insurance.demo.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PolicyHolderDTO {

    private Long policyHolderId;

    @NotNull(message = "Name cannot be null")
    private String policyHolderName;

    @NotNull(message = "Date of Birth cannot be null")
    private LocalDate policyHolderDob;

    @NotNull(message = "Gender cannot be null")
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
