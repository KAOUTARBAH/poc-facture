package com.bts.poc.facture.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bts.poc.facture.model.ERole;
import com.bts.poc.facture.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
