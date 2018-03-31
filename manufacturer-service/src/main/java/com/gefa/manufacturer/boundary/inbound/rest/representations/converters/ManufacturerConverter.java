package com.gefa.manufacturer.boundary.inbound.rest.representations.converters;

import com.gefa.manufacturer.application.domain.Manufacturer;
import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.boundary.inbound.rest.representations.Link;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManufacturerConverter {

	public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation) {

		return new Manufacturer(manufacturerRepresentation.getId(),
				manufacturerRepresentation.getManufacturerName());

	}

	public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation, Long manufacturerId) {
		return new Manufacturer(manufacturerId, manufacturerRepresentation.getManufacturerName());

	}

	public ManufacturerRepresentation fromManufacturer(Manufacturer manufacturer, Link... links) {
		return new ManufacturerRepresentation(manufacturer, links);
	}

}
