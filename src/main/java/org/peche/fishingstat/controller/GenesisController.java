package org.peche.fishingstat.controller;

import java.util.List;

import javax.validation.Valid;

import org.peche.fishingstat.dao.GenesisRepository;
import org.peche.fishingstat.general.ResourceNotFoundException;
import org.peche.fishingstat.model.Genesis;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GenesisController {
	
	@Autowired
	GenesisRepository genesisRepository;
	
    // Get All Genesis
	@GetMapping("/genesis")
	public List<Genesis> getAllGenesis() {
//		List<Genesis> collection = new ArrayList<Genesis>();
//	    genesisRepository.findAll().forEach(collection::add);
//	    return collection;
	    return genesisRepository.findAll();
	}
	
	@PostMapping("/genesis")
	public Genesis createGenesis(@Valid @RequestBody Genesis genesis) {
		return genesisRepository.save(genesis);
	}

	// Get a Single Genesis
	@GetMapping("/genesis/{id}")
	public Genesis getGenesisById(@PathVariable(value = "id") Long genesisId) {
	    return genesisRepository.findById(genesisId)
	            .orElseThrow(() -> new ResourceNotFoundException("Genesis", "id", genesisId));
	}
	
	// Update a Genesis
	@PutMapping("/genesis/{id}")
	public Genesis updateGenesis(@PathVariable(value = "id") Long genesisId,
	                                        @Valid @RequestBody Genesis genesisDetails) {

	    Genesis genesis = genesisRepository.findById(genesisId)
	            .orElseThrow(() -> new ResourceNotFoundException("Genesis", "id", genesisId));

	    genesis.setName(genesisDetails.getName());
	    genesis.setShortName(genesisDetails.getShortName());
	    genesis.setDescription(genesisDetails.getDescription());

	    Genesis updatedGenesis = genesisRepository.save(genesis);
	    return updatedGenesis;
	}

	// Delete a Genesis
	@DeleteMapping("/genesis/{id}")
	public ResponseEntity<?> deleteGenesis(@PathVariable(value = "id") Long genesisId) {
	    Genesis genesis = genesisRepository.findById(genesisId)
	            .orElseThrow(() -> new ResourceNotFoundException("Genesis", "id", genesisId));

	    genesisRepository.delete(genesis);

	    return ResponseEntity.ok().build();
	}

}
