package com.godigit.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.godigit.graphql.model.Claim;
import com.godigit.graphql.model.Policy;
import com.godigit.graphql.reposiotry.PolicyRepository;

import lombok.AllArgsConstructor;

/**
 * Resolver for Policy object. This class will be invoked and correspoding data
 * fetcher will be called f Policy is used as subquery in Root Query or extended
 * RootQuery
 */
@AllArgsConstructor
public class PolicyResolver implements GraphQLResolver<Policy> {

	private PolicyRepository policyRepository;

	public Policy getPolicy(Claim claim) {
		return policyRepository.findById(claim.getPolicy().getPolicyId()).orElse(null);
	}

}
