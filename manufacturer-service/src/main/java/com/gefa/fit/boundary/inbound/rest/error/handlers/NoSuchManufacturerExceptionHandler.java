package com.gefa.fit.boundary.inbound.rest.error.handlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.gefa.fit.application.exceptions.NoSuchManufacturerException;
import com.gefa.fit.boundary.inbound.rest.error.ErrorCodeNum;
import com.gefa.fit.boundary.inbound.rest.error.GeneralErrorCode;

@Provider
public class NoSuchManufacturerExceptionHandler implements ExceptionMapper<NoSuchManufacturerException> {

	@Override
	public Response toResponse(NoSuchManufacturerException exception) {
		return Response.status(Status.NOT_FOUND)
				.entity(new GeneralErrorCode(String.valueOf(Status.NOT_FOUND),
						ErrorCodeNum.RESOORCE_NOT_FOUND.getUserMessage(), exception.getLocalizedMessage().toString()))
				.build();
	}

}
