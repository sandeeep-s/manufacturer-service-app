package com.gefa.manufacturer.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.manufacturer.application.ManufacturerService;
import com.gefa.manufacturer.application.domain.Manufacturer;
import com.gefa.manufacturer.application.domain.ManufacturerCreatedState;
import com.gefa.manufacturer.application.exceptions.NoSuchManufacturerException;
import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.boundary.inbound.rest.representations.Link;
import com.gefa.manufacturer.boundary.inbound.rest.representations.converters.ManufacturerConverter;

@ApplicationScoped
public class ReadManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	@Inject
	private ManufacturerConverter manufacturerConverter;

	public ReadManufacturerActivity() {
		// TODO Auto-generated constructor stub
	}

	public ManufacturerRepresentation retrieveById(Long manufacturerId, UriInfo uriInfo) throws NoSuchManufacturerException {
		Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturerId);

		if (null == manufacturer) {
			throw new NoSuchManufacturerException("Manufacturer with id " + manufacturerId + " not found");
		}

		String manufacturerURI = uriInfo.getRequestUri().toString();

		Link manufacturerSelflink = new Link("self", manufacturerURI, MediaType.APPLICATION_XML);
		ManufacturerRepresentation manufacturerRepresentation = new ManufacturerRepresentation(manufacturer, manufacturerSelflink);

		if (manufacturer.getManufacturerState().equals(new ManufacturerCreatedState(manufacturer))) {
			String approveURI = uriInfo.getBaseUri() + "approve/" + manufacturerId;
			Link manufacturerApprovelink = new Link("approve", approveURI, MediaType.APPLICATION_XML);
			Link manufacturerUpdatelink = new Link("update", manufacturerURI, MediaType.APPLICATION_XML);
			Link manufacturerDeletelink = new Link("remove", manufacturerURI, MediaType.APPLICATION_XML);
			manufacturerRepresentation = new ManufacturerRepresentation(manufacturer, manufacturerSelflink, manufacturerUpdatelink, manufacturerDeletelink,
					manufacturerApprovelink);
		}

		return manufacturerRepresentation;

	}

}
