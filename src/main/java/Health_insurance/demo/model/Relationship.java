package Health_insurance.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getPersonRelation() {
		return personRelation;
	}

	public void setPersonRelation(String personRelation) {
		this.personRelation = personRelation;
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

	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}

	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}

	private String personRelation;
    private String personName;
    private String personGender;
    private LocalDate personDOB;

    @ManyToOne
    @JoinColumn(name = "policyHolderId", nullable = false)
    private PolicyHolder policyHolder;

}
