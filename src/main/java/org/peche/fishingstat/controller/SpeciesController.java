package org.peche.fishingstat.controller;

import javax.validation.Valid;

import org.peche.fishingstat.dao.SpeciesRepository;
import org.peche.fishingstat.general.ResourceNotFoundException;
import org.peche.fishingstat.model.Species;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpeciesController {
	
	@Autowired
	SpeciesRepository speciesRepository;
	
    // Get All Species
	@GetMapping("/species")
	public Page<Species> getAllSpecies(Pageable pageable) {
//		List<Species> collection = new ArrayList<Species>();
//	    speciesRepository.findAll().forEach(collection::add);
//	    return collection;
	    return speciesRepository.findAll(pageable);
	}
	
	@PostMapping("/species")
	public Species createSpecies(@Valid @RequestBody Species species) {
		return speciesRepository.save(species);
	}

	// Get a Single Species
	@GetMapping("/species/{id}")
	public Species getSpeciesById(@PathVariable(value = "id") Long speciesId) {
	    return speciesRepository.findById(speciesId)
	            .orElseThrow(() -> new ResourceNotFoundException("Species", "id", speciesId));
	}
	
	// Update a Species
	@PutMapping("/species/{id}")
	public Species updateSpecies(@PathVariable(value = "id") Long speciesId,
	                                        @Valid @RequestBody Species speciesDetails) {

	    Species species = speciesRepository.findById(speciesId)
	            .orElseThrow(() -> new ResourceNotFoundException("Species", "id", speciesId));

	    species.setName(speciesDetails.getName());
	    species.setShortName(speciesDetails.getShortName());
	    species.setDescription(speciesDetails.getDescription());
	    species.setNature(speciesDetails.getNature());
	    species.setLatinName(speciesDetails.getLatinName());
	    species.setOrigine(speciesDetails.getOrigine());
	    species.setHabitat(speciesDetails.getHabitat());

	    Species updatedSpecies = speciesRepository.save(species);
	    return updatedSpecies;
	}

	// Delete a Species
	@DeleteMapping("/species/{id}")
	public ResponseEntity<?> deleteSpecies(@PathVariable(value = "id") Long speciesId) {
	    Species species = speciesRepository.findById(speciesId)
	            .orElseThrow(() -> new ResourceNotFoundException("Species", "id", speciesId));

	    speciesRepository.delete(species);

	    return ResponseEntity.ok().build();
	}

}
