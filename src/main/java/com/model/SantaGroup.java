package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class SantaGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="GROUP_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer GroupId;
	
	@Column(name="GROUP_NAME",nullable = false)
	private String groupName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="CREATION_DATE",nullable = false)
	private Date creationDate;
	
	@Column(name="GIFT_EXCHANGE_DATE", nullable = false)
	private Date giftExchangeDate;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional=true)
	private Address address;
	
	@Column(name="PRICE_LIMIT", nullable = false)
	private Double priceLimit;
	
	@OneToMany(mappedBy = "santaGroup",cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
	@JsonManagedReference
	private List<SecretMember> participant;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getGiftExchangeDate() {
		return giftExchangeDate;
	}

	public void setGiftExchangeDate(Date giftExchangeDate) {
		this.giftExchangeDate = giftExchangeDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Double getPriceLimit() {
		return priceLimit;
	}

	public void setPriceLimit(Double priceLimit) {
		this.priceLimit = priceLimit;
	}

	public Integer getGroupId() {
		return GroupId;
	}

	public void setGroupId(Integer groupId) {
		GroupId = groupId;
	}

	public List<SecretMember> getParticipant() {
		return participant;
	}

	public void setParticipant(List<SecretMember> participant) {
		this.participant = participant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((giftExchangeDate == null) ? 0 : giftExchangeDate.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result
				+ ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((participant == null) ? 0 : participant.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SantaGroup other = (SantaGroup) obj;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (giftExchangeDate == null) {
			if (other.giftExchangeDate != null)
				return false;
		} else if (!giftExchangeDate.equals(other.giftExchangeDate))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (participant == null) {
			if (other.participant != null)
				return false;
		} else if (!participant.equals(other.participant))
			return false;
		if (Double.doubleToLongBits(priceLimit) != Double
				.doubleToLongBits(other.priceLimit))
			return false;
		return true;
	}
	

}
