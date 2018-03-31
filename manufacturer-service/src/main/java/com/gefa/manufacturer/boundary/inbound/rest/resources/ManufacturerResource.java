package com.gefa.manufacturer.boundary.inbound.rest.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gefa.manufacturer.boundary.inbound.rest.representations.ManufacturerRepresentation;

@Path("/manufacturer")
@Api(value = "manufacturers")
@SwaggerDefinition(tags = { @Tag(name = "manufacturers", description = "Operations on manufacturers.") })
public interface ManufacturerResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Create an manufacturer", notes = "Create an manufacturer in EKF Tool")
	@ApiResponses(@ApiResponse(code = 200, message = "Manufacturer has been created"))
	Response addManufacturer(ManufacturerRepresentation manufacturerRepresentation);

	@POST
	@Path("/{manufacturerId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    ManufacturerRepresentation updateManufacturer(@PathParam("manufacturerId") Long id, ManufacturerRepresentation manufacturerRepresentation);

	@GET
	@Path("/{manufacturerId}")
	@Produces(MediaType.APPLICATION_JSON)
	Response getManufacturer(@PathParam("manufacturerId") Long id);

	@DELETE
	@Path("/{manufacturerId}")
	@Produces(MediaType.APPLICATION_JSON)
	Response removeManufacturer(@PathParam("manufacturerId") Long id);

}
