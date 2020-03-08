package com.godigit.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = { "claimId" })
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Claim {

	public Claim() {
	}
	
	@Id
	@Column(name = "claim_Id", nullable = false)
	private String claimId;

	@Column(name = "registered_by", nullable = false)
	private String registeredBy;

	@Column(name = "is_settled", nullable = false)
	private Boolean isSettled;

	@ManyToOne
	@JoinColumn(name = "policyId", nullable = false, updatable = false)
	private Policy policy;
}
