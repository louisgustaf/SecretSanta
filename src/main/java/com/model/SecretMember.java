package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SecretMember {
	
	@Id
    @Column(name="SECRET_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int SecretId;
	
	@Column(name="MEMBER_NAME", nullable = false)
	private String memberName;
	
	@OneToMany(mappedBy = "secretMember",cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
	private List<Interest> interests;
	
	@Column(name="SECRET_SANTA")
	private String secretSanta;
	
	@Column(name="EMAIL", nullable = false)
	private String email;

	public String getMemberName() {
		return memberName;
	}
	
	@ManyToOne(optional=false)
    @JoinColumn(name="GROUP_ID", referencedColumnName="GROUP_ID")
	private SantaGroup santaGroup;

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public String getSecretSanta() {
		return secretSanta;
	}

	public void setSecretSanta(String secretSanta) {
		this.secretSanta = secretSanta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public int getSecretId() {
		return SecretId;
	}

	public void setSecretId(int secretId) {
		SecretId = secretId;
	}

	public SantaGroup getSantaGroup() {
		return santaGroup;
	}

	public void setSantaGroup(SantaGroup santaGroup) {
		this.santaGroup = santaGroup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((interests == null) ? 0 : interests.hashCode());
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result
				+ ((secretSanta == null) ? 0 : secretSanta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecretMember other = (SecretMember) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (interests == null) {
			if (other.interests != null)
				return false;
		} else if (!interests.equals(other.interests))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (secretSanta == null) {
			if (other.secretSanta != null)
				return false;
		} else if (!secretSanta.equals(other.secretSanta))
			return false;
		return true;
	}

}
