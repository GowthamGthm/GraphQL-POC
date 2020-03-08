package com.godigit.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.godigit.graphql.model.Policy;
import com.godigit.graphql.model.PolicyType;
import com.godigit.graphql.reposiotry.PolicyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	private PolicyRepository policyRepository;
	
	public Policy newPolicy(String policyId, String firstName, String lastName, PolicyType type) {
		Policy policy = new Policy(policyId, firstName, lastName, type, null);
		Policy savedPolicy = policyRepository.save(policy);
		return savedPolicy;
	}
}
