package com.bts.poc.facture.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bts.poc.facture.model.Facture;

@Repository
public interface IFactureRepository extends MongoRepository<Facture, Long> {

}
