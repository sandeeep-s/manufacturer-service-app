package com.gefa.fit.boundary.inbound.rest.representations.converters;

import com.gefa.fit.application.domain.Manufacturer;
import com.gefa.fit.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.fit.boundary.inbound.rest.representations.Link;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManufacturerConverter {

	public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation) {

		return new Manufacturer(manufacturerRepresentation.getId(),
				manufacturerRepresentation.getManufacturerName());

	}

	public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation, Long assetId) {
		return new Manufacturer(assetId, manufacturerRepresentation.getManufacturerName());

	}

	public ManufacturerRepresentation fromManufacturer(Manufacturer manufacturer, Link... links) {
		return new ManufacturerRepresentation(manufacturer, links);
	}

}
