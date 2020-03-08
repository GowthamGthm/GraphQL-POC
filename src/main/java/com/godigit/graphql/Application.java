package com.godigit.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.godigit.graphql.model.Claim;
import com.godigit.graphql.model.Policy;
import com.godigit.graphql.model.PolicyType;
import com.godigit.graphql.reposiotry.ClaimRepository;
import com.godigit.graphql.reposiotry.PolicyRepository;
import com.godigit.graphql.resolver.PolicyResolver;
import com.godigit.graphql.resolver.ClaimsQueryHandler;
import com.godigit.graphql.resolver.Mutation;
import com.godigit.graphql.resolver.RootQueryHandler;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RootQueryHandler query(ClaimRepository claimRepository, PolicyRepository policyRepository) {
		return new ClaimsQueryHandler(claimRepository, policyRepository, new RestTemplate());
	}

	@Bean
	public PolicyResolver policyResolver(PolicyRepository policyRepository) {
		return new PolicyResolver(policyRepository);
	}
	
	@Bean
	public Mutation mutation(PolicyRepository policyRepository) {
		return new Mutation(policyRepository);
	}

	@Bean
	public CommandLineRunner load(PolicyRepository policyRepo, ClaimRepository claimsRepo) {
		return (args) -> {
			Policy p1 = new Policy("1", "Prashanth", "Rao", PolicyType.TWOWHEELER, "Codes");
			Policy p2 = new Policy("2", "Johnny", "Bravo", PolicyType.FOURWHEELER, null);
			Policy p3 = new Policy("3", "Laure", "D", PolicyType.TWOWHEELER, null);
			Policy p4 = new Policy("4", "Srinivas", "FNOL", PolicyType.FOURWHEELER, "FNOL");
			Policy p5 = new Policy("5", "Gowtham", "P", PolicyType.FOURWHEELER, "Anna");
			Policy p6 = new Policy("6", "Sivanna", "Kumar", PolicyType.FOURWHEELER, "Artist");

			policyRepo.save(p1);
			policyRepo.save(p2);
			policyRepo.save(p3);
			policyRepo.save(p4);
			policyRepo.save(p5);
			policyRepo.save(p6);

			createClaims(p2, 2, claimsRepo);
			createClaims(p3, 3, claimsRepo);
			createClaims(p4, 4, claimsRepo);
			createClaims(p5, 5, claimsRepo);
			createClaims(p6, 6, claimsRepo);
		};
	}

	private void createClaims(Policy policy, int numberOfClaims, ClaimRepository claimsRepo) {
		List<Claim> claims = new ArrayList<>();
		for (int i = 0; i < numberOfClaims; i++) {
			claims.add(Claim.builder().claimId(i + "-" + policy.getPolicyId()).registeredBy(i + "-Name")
					.isSettled(i % 2 == 0).policy(policy).build());
		}
		claimsRepo.saveAll(claims);
	}

}
