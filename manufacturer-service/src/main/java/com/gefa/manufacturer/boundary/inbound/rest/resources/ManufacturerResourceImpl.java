package com.gefa.manufacturer.boundary.inbound.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.gefa.manufacturer.application.exceptions.ManufacturerRemovalException;
import com.gefa.manufacturer.boundary.inbound.rest.activities.CreateManufacturerActivity;
import com.gefa.manufacturer.boundary.inbound.rest.activities.ReadManufacturerActivity;
import com.gefa.manufacturer.boundary.inbound.rest.activities.RemoveManufacturerActivity;
import com.gefa.manufacturer.boundary.inbound.rest.activities.UpdateManufacturerActivity;
import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;

public class ManufacturerResourceImpl implements ManufacturerResource {

	@Inject
	private CreateManufacturerActivity createManufacturerActivity;

	@Inject
	private UpdateManufacturerActivity updateManufacturerActivity;

	@Inject
	private ReadManufacturerActivity readManufacturerActivity;

	@Inject
	private RemoveManufacturerActivity removeManufacturerActivity;

	@Context
	UriInfo uriInfo;

	public Response addManufacturer(ManufacturerRepresentation manufacturerRepresentation) {
		ResponseBuilder builder = null;
		try{
		ManufacturerRepresentation responseRepresentation = createManufacturerActivity.create(manufacturerRepresentation, uriInfo);
		builder = Response.status(Status.CREATED).type(MediaType.APPLICATION_JSON)
				.entity(responseRepresentation);


	}catch(Exception e){
		e.printStackTrace();
	}
		return builder.build();
	}

	public ManufacturerRepresentation updateManufacturer(Long manufacturerId, ManufacturerRepresentation manufacturerRepresentation) {
		ManufacturerRepresentation responseRepresentation = updateManufacturerActivity.update(manufacturerId, manufacturerRepresentation, uriInfo);
		return responseRepresentation;
	}

	public Response getManufacturer(Long manufacturerId) {
		ManufacturerRepresentation responseRepresentation = readManufacturerActivity.retrieveById(manufacturerId, uriInfo);
		ResponseBuilder builder = Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
				.entity(responseRepresentation);
		return builder.build();
	}

	public Response removeManufacturer(Long manufacturerId) {
		try {
			ManufacturerRepresentation responseRepresentation = removeManufacturerActivity.delete(manufacturerId);
			ResponseBuilder builder = Response.status(Status.OK).type(MediaType.APPLICATION_JSON)
					.entity(responseRepresentation);
			return builder.build();
		} catch (ManufacturerRemovalException e) {
			return Response.status(Status.METHOD_NOT_ALLOWED).build();
		}
	}

}
