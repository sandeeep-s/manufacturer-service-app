package com.gefa.fit.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.fit.application.ManufacturerService;
import com.gefa.fit.application.domain.Manufacturer;
import com.gefa.fit.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.fit.boundary.inbound.rest.representations.Link;
import com.gefa.fit.boundary.inbound.rest.representations.converters.ManufacturerConverter;

@ApplicationScoped
public class UpdateManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	@Inject
	private ManufacturerConverter manufacturerConverter;

	public ManufacturerRepresentation update(Long id, ManufacturerRepresentation manufacturerRepresentation, UriInfo uriInfo) {
		Manufacturer manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation, id);

		manufacturerService.update(manufacturer);

		String assetURI = uriInfo.getRequestUri().toString();
		Link assetSelflink = new Link("self", assetURI, MediaType.APPLICATION_XML);
		Link assetUpdatelink = new Link("update", assetURI, MediaType.APPLICATION_XML);
		Link assetDeletelink = new Link("remove", assetURI, MediaType.APPLICATION_XML);

		return new ManufacturerRepresentation(manufacturer, assetSelflink, assetUpdatelink, assetDeletelink);
	}

}
