package com.bts.poc.facture.repository;




import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bts.poc.facture.model.Facture;

@Repository
public interface IFactureRepository extends MongoRepository<Facture, Long> {

	List<Facture> findFactureByLibelle(@Param("mc") String libelle);
}
