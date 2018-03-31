package com.gefa.manufacturer.client.representations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gefa.manufacturer.client.domain.Manufacturer;

public class ManufacturerRepresentation extends Representation {

	private Long id;
	private String manufacturerName;
	private String manufacturerStatus;

	public ManufacturerRepresentation() {

	}

	public ManufacturerRepresentation(Manufacturer manufacturer) {
		this.manufacturerName = manufacturer.getManufacturerName();
		this.manufacturerStatus = manufacturer.getManufacturerStatus();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerStatus() {
		return manufacturerStatus;
	}

	public void setManufacturerStatus(String manufacturerStatus) {
		this.manufacturerStatus = manufacturerStatus;
	}

	@JsonIgnore
	public Link getSelfLink() {
		return getLinkByName("self");
	}

	@JsonIgnore
	public Link getUpdateLink() {
		return getLinkByName("update");
	}

	@JsonIgnore
	public Link getRemoveLink() {
		return getLinkByName("remove");
	}

}
