package com.godigit.graphql.reposiotry;

import org.springframework.data.repository.CrudRepository;

import com.godigit.graphql.model.Claim;

public interface ClaimRepository extends CrudRepository<Claim, String> {
}
