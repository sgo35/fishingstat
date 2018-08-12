package org.peche.fishingstat.controller;

	import javax.validation.Valid;

import org.peche.fishingstat.dao.NamingRepository;
import org.peche.fishingstat.dao.SpeciesRepository;
import org.peche.fishingstat.general.ResourceNotFoundException;
import org.peche.fishingstat.model.Naming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class NamingController {

	    @Autowired
	    private NamingRepository namingRepository;

	    @Autowired
	    private SpeciesRepository speciesRepository;

	    @GetMapping("/species/{speciesId}/namings")
	    public Page<Naming> getAllNamingsBySpeciesId(@PathVariable (value = "speciesId") Long speciesId,
	                                                Pageable pageable) {
	        return namingRepository.findBySpeciesId(speciesId, pageable);
	    }

	    @PostMapping("/species/{speciesId}/namings")
	    public Naming createNaming(@PathVariable (value = "speciesId") Long speciesId,
	                                 @Valid @RequestBody Naming naming) {
	        return speciesRepository.findById(speciesId).map(species -> {
	            naming.setSpecies(species);
	            return namingRepository.save(naming);
	        }).orElseThrow(() -> new ResourceNotFoundException("Species", "id", speciesId));
	    }

	    @PutMapping("/species/{speciesId}/namings/{namingId}")
	    public Naming updateNaming(@PathVariable (value = "speciesId") Long speciesId,
	                                 @PathVariable (value = "namingId") Long namingId,
	                                 @Valid @RequestBody Naming namingRequest) {
	        if(!speciesRepository.existsById(speciesId)) {
	            throw new ResourceNotFoundException("Species", "id", speciesId);
	        }

	        return namingRepository.findById(namingId).map(naming -> {
	            naming.setLang(namingRequest.getLang());
	            naming.setDesignation(namingRequest.getDesignation());
	            return namingRepository.save(naming);
	        }).orElseThrow(() -> new ResourceNotFoundException("Naming", "id", namingId));
	    }

	    @DeleteMapping("/species/{speciesId}/namings/{namingId}")
	    public ResponseEntity<?> deleteNaming(@PathVariable (value = "speciesId") Long speciesId,
	                              @PathVariable (value = "namingId") Long namingId) {
	        if(!speciesRepository.existsById(speciesId)) {
	            throw new ResourceNotFoundException("Species", "id", speciesId);
	        }

	        return namingRepository.findById(namingId).map(naming -> {
	             namingRepository.delete(naming);
	             return ResponseEntity.ok().build();
	        }).orElseThrow(() -> new ResourceNotFoundException("Naming", "id", namingId));
	    }
	}