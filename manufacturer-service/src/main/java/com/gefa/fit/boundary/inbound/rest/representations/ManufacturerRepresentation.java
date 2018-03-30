package com.gefa.fit.boundary.inbound.rest.representations;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gefa.fit.application.domain.Manufacturer;

public class ManufacturerRepresentation extends Representation {

	private Long id;
	private String manufacturerName;
	private String manufacturerStatus;

	public ManufacturerRepresentation() {

	}

	public ManufacturerRepresentation(Manufacturer manufacturer, Link... links) {
		this.manufacturerName = manufacturer.getManufacturerName();
		this.manufacturerStatus = manufacturer.getManufacturerState().toString();
		this.links = Arrays.asList(links);

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

	@JsonIgnore
	public Link getApproveLink() {
		return getLinkByName("approve");
	}

}
