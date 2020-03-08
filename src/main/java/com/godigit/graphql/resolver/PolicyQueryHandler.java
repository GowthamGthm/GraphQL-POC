package com.godigit.graphql.resolver;

import java.util.Optional;

import org.springframework.web.client.RestTemplate;

import com.godigit.graphql.model.Policy;
import com.godigit.graphql.reposiotry.PolicyRepository;

/**
 * GraphQL Query on extended Policy Query -- policy.graphqls
 *
 */
public class PolicyQueryHandler extends RootQueryHandler {

	private PolicyRepository policyRepository;
	
	public PolicyQueryHandler(PolicyRepository policyRepository, RestTemplate restTemplate) {
		super(restTemplate);
		this.policyRepository = policyRepository;
	}
	
	/**
	 * Returns all policies
	 */
	public Iterable<Policy> allPolicies() {
		return policyRepository.findAll();
	}
	
	public Policy policyById(String policyId) {
		Optional<Policy> optional = policyRepository.findById(policyId);
		return optional.orElse(null);
	}
	
	public long countOfPolicies() {
		return policyRepository.count();
	}
}
