package com.gefa.manufacturer.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.manufacturer.application.ManufacturerService;
import com.gefa.manufacturer.application.domain.Manufacturer;
import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.boundary.inbound.rest.representations.Link;
import com.gefa.manufacturer.boundary.inbound.rest.representations.converters.ManufacturerConverter;

@ApplicationScoped
public class CreateManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	@Inject
	private ManufacturerConverter manufacturerConverter;

	public CreateManufacturerActivity() {

	}

	public ManufacturerRepresentation create(ManufacturerRepresentation manufacturerRepresentation, UriInfo uriInfo) {

		Manufacturer manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation);
		Long manufacturerId = manufacturerService.create(manufacturer);

		String manufacturerURI = uriInfo.getBaseUri() + "manufacturer/" + manufacturerId;
		Link manufacturerSelflink = new Link("self", manufacturerURI, MediaType.APPLICATION_XML);
		Link manufacturerUpdatelink = new Link("update", manufacturerURI, MediaType.APPLICATION_XML);
		Link manufacturerDeletelink = new Link("remove", manufacturerURI, MediaType.APPLICATION_XML);

		return new ManufacturerRepresentation(manufacturer, manufacturerSelflink, manufacturerUpdatelink, manufacturerDeletelink);
	}

}
