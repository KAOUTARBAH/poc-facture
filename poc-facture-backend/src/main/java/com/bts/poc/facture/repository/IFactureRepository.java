package com.bts.poc.facture.repository;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bts.poc.facture.model.Facture;

@Repository
public interface IFactureRepository extends MongoRepository<Facture, Long> {

	List<Facture> findFactureByLibelle(@Param("mc") String libelle );
	
	
	Page<Facture> findFactureByLibelle(@Param("mc") String libelle ,Pageable pageable);
	
	Facture getFactureByLibelle(String libelle );
}
