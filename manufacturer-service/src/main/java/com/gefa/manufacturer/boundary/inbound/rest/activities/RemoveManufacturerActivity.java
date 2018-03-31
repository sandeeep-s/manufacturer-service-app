package com.gefa.manufacturer.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.manufacturer.application.ManufacturerService;
import com.gefa.manufacturer.application.domain.Manufacturer;
import com.gefa.manufacturer.application.exceptions.ManufacturerRemovalException;
import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;

@ApplicationScoped
public class RemoveManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	public ManufacturerRepresentation delete(Long manufacturerId) throws ManufacturerRemovalException {

		Manufacturer manufacturer = manufacturerService.removeManufacturer(manufacturerId);
		

		return new ManufacturerRepresentation(manufacturer);
	}

}
