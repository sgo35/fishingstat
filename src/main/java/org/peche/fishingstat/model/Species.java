package org.peche.fishingstat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "species")
public class Species extends Genesis {

	@NotNull
	@Column(unique = true)
	private String latinName;

	private String nature;
	private String habitat;
	private String origine;
	private String behavior;
	private String otherFeatures;

	private int minimumSize;
	private int mediumSize;
	private int maximumSize;

	private int minimumWeight;
	private int mediumWeight;
	private int maximumWeight;

	@Lob
	private String image;

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public String getOtherFeatures() {
		return otherFeatures;
	}

	public void setOtherFeatures(String otherFeatures) {
		this.otherFeatures = otherFeatures;
	}

	public int getMinimumSize() {
		return minimumSize;
	}

	public void setMinimumSize(int minimumSize) {
		this.minimumSize = minimumSize;
	}

	public int getMediumSize() {
		return mediumSize;
	}

	public void setMediumSize(int mediumSize) {
		this.mediumSize = mediumSize;
	}

	public int getMaximumSize() {
		return maximumSize;
	}

	public void setMaximumSize(int maximumSize) {
		this.maximumSize = maximumSize;
	}

	public int getMinimumWeight() {
		return minimumWeight;
	}

	public void setMinimumWeight(int minimumWeight) {
		this.minimumWeight = minimumWeight;
	}

	public int getMediumWeight() {
		return mediumWeight;
	}

	public void setMediumWeight(int mediumWeight) {
		this.mediumWeight = mediumWeight;
	}

	public int getMaximumWeight() {
		return maximumWeight;
	}

	public void setMaximumWeight(int maximumWeight) {
		this.maximumWeight = maximumWeight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
