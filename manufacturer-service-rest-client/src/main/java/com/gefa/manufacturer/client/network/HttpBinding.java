package com.gefa.manufacturer.client.network;


import com.gefa.manufacturer.client.exceptions.*;
import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

public class HttpBinding {

    public ManufacturerRepresentation createManufacturer(ManufacturerRepresentation manufacturerRepresentation, URI manufacturerURI)
            throws MalformedManufacturerException, ServiceFailureException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(manufacturerURI);

        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(manufacturerRepresentation, MediaType.APPLICATION_JSON));

        int status = response.getStatus();

        if (status == 400) {
            throw new MalformedManufacturerException();
        } else if (status == 500) {
            throw new ServiceFailureException();
        } else if (status == 201) {
            return response.readEntity(ManufacturerRepresentation.class);
        }

        throw new RuntimeException(String.format("Unexpected response [%d] while creating manufacturer resource [%s]", status,
                manufacturerURI.toString()));

    }

    public ManufacturerRepresentation retrieveManufacturer(URI manufacturerURI) throws NotFoundException, ServiceFailureException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(manufacturerURI);

        Response response = target.request(MediaType.APPLICATION_JSON).get();

        int status = response.getStatus();

        if (status == 404) {
            throw new NotFoundException();
        } else if (status == 500) {
            throw new ServiceFailureException();
        } else if (status == 200) {
            return response.readEntity(ManufacturerRepresentation.class);
        }

        throw new RuntimeException(String.format("Unexpected response [%d] while retrieveing manufacturer resource [%s]",
                status, manufacturerURI.toString()));
    }

    public ManufacturerRepresentation updateManufacturer(ManufacturerRepresentation manufacturerRepresentation, URI manufacturerURI)
            throws MalformedManufacturerException, NotFoundException, CannotUpdateManufacturerException, ServiceFailureException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(manufacturerURI);

        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(manufacturerRepresentation, MediaType.APPLICATION_JSON));

        int status = response.getStatus();

        if (400 == status) {
            throw new MalformedManufacturerException();
        } else if (404 == status) {
            throw new NotFoundException();
        } else if (409 == status) {
            throw new CannotUpdateManufacturerException();
        } else if (500 == status) {
            throw new ServiceFailureException();
        } else if (200 == status) {
            return response.readEntity(ManufacturerRepresentation.class);
        }

        throw new RuntimeException(String.format("Unexpected response [%d] while updating manufacturer resource [%s]", status,
                manufacturerURI.toString()));
    }

    public ManufacturerRepresentation removeManufacturer(URI manufacturerURI)
            throws NotFoundException, ServiceFailureException, CannotCancelException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(manufacturerURI);

        Response response = target.request(MediaType.APPLICATION_JSON).delete();

        int status = response.getStatus();

        if (status == 404) {
            throw new NotFoundException();
        } else if (status == 405) {
            throw new CannotCancelException();
        } else if (status == 500) {
            throw new ServiceFailureException();
        } else if (status == 200) {
            return response.readEntity(ManufacturerRepresentation.class);
        }

        throw new RuntimeException(String.format("Unexpected response [%d] while removing manufacturer resource [%s]", status,
                manufacturerURI.toString()));
    }

}
