package com.godigit.graphql.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of = { "policyId" })
@AllArgsConstructor
@Getter
@Setter
public class Policy {

	public Policy() {
	}

	@Id
	@Column(name = "policyId", nullable = false)
	private String policyId;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "type", nullable = false)
	private PolicyType type;

	@Column(name = "additional_details", nullable = true)
	private String additionalDetails;
	
}
