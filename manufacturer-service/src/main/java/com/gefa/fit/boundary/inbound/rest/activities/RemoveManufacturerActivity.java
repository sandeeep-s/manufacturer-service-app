package com.gefa.fit.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.ManufacturerService;
import com.gefa.fit.application.domain.Manufacturer;
import com.gefa.fit.application.exceptions.ManufacturerRemovalException;
import com.gefa.fit.boundary.inbound.rest.representations.ManufacturerRepresentation;

@ApplicationScoped
public class RemoveManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	public ManufacturerRepresentation delete(Long assetId) throws ManufacturerRemovalException {

		Manufacturer manufacturer = manufacturerService.removeManufacturer(assetId);
		

		return new ManufacturerRepresentation(manufacturer);
	}

}
