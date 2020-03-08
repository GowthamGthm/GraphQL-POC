package com.godigit.graphql.reposiotry;

import org.springframework.data.repository.CrudRepository;

import com.godigit.graphql.model.Policy;

public interface PolicyRepository extends CrudRepository<Policy, String>{
}
