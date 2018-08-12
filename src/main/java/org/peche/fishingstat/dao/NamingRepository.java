package org.peche.fishingstat.dao;

import org.peche.fishingstat.model.Naming;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamingRepository extends JpaRepository<Naming, Long>{
	 Page<Naming> findBySpeciesId(Long postId, Pageable pageable);
}
