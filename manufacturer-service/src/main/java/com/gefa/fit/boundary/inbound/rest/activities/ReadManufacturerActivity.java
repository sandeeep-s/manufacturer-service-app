package com.gefa.fit.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gefa.fit.application.ManufacturerService;
import com.gefa.fit.application.domain.Manufacturer;
import com.gefa.fit.application.domain.ManufacturerCreatedState;
import com.gefa.fit.application.exceptions.NoSuchManufacturerException;
import com.gefa.fit.boundary.inbound.rest.representations.ManufacturerRepresentation;
import com.gefa.fit.boundary.inbound.rest.representations.Link;
import com.gefa.fit.boundary.inbound.rest.representations.converters.ManufacturerConverter;

@ApplicationScoped
public class ReadManufacturerActivity {

	@Inject
	private ManufacturerService manufacturerService;

	@Inject
	private ManufacturerConverter manufacturerConverter;

	public ReadManufacturerActivity() {
		// TODO Auto-generated constructor stub
	}

	public ManufacturerRepresentation retrieveById(Long assetId, UriInfo uriInfo) throws NoSuchManufacturerException {
		Manufacturer manufacturer = manufacturerService.getManufacturer(assetId);

		if (null == manufacturer) {
			throw new NoSuchManufacturerException("Manufacturer with id " + assetId + " not found");
		}

		String assetURI = uriInfo.getRequestUri().toString();

		Link assetSelflink = new Link("self", assetURI, MediaType.APPLICATION_XML);
		ManufacturerRepresentation manufacturerRepresentation = new ManufacturerRepresentation(manufacturer, assetSelflink);

		if (manufacturer.getManufacturerState().equals(new ManufacturerCreatedState(manufacturer))) {
			String approveURI = uriInfo.getBaseUri() + "approve/" + assetId;
			Link assetApprovelink = new Link("approve", approveURI, MediaType.APPLICATION_XML);
			Link assetUpdatelink = new Link("update", assetURI, MediaType.APPLICATION_XML);
			Link assetDeletelink = new Link("remove", assetURI, MediaType.APPLICATION_XML);
			manufacturerRepresentation = new ManufacturerRepresentation(manufacturer, assetSelflink, assetUpdatelink, assetDeletelink,
					assetApprovelink);
		}

		return manufacturerRepresentation;

	}

}
