package org.peche.fishingstat.dao;

import org.peche.fishingstat.model.Genesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenesisRepository extends JpaRepository<Genesis, Long>{

}
