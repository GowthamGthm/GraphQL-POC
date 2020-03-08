package com.godigit.graphql.resolver;

import org.springframework.web.client.RestTemplate;

import com.godigit.graphql.model.Claim;
import com.godigit.graphql.reposiotry.ClaimRepository;
import com.godigit.graphql.reposiotry.PolicyRepository;

/**
 * GraphQL Query on extended Policy Query -- clams.graphqls
 */
public class ClaimsQueryHandler extends PolicyQueryHandler {

	private ClaimRepository claimRepository;
	
	public ClaimsQueryHandler(
			ClaimRepository claimRepository,
			PolicyRepository policyRepository,
			RestTemplate restTempalte) {
		super(policyRepository, restTempalte);
		this.claimRepository = claimRepository;
	}
	public Iterable<Claim> allClaims() {
		return claimRepository.findAll();
	}
	
	public Claim claimById(String claimId) {
		return claimRepository.findById(claimId).orElse(null);
	}
	
	public long countOfClaims() {
		return claimRepository.count();
	}

}
