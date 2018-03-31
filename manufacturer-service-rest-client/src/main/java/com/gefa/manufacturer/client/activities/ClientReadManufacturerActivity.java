package com.gefa.manufacturer.client.activities;

import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.client.representations.converters.ManufacturerConverter;
import com.gefa.manufacturer.client.domain.Manufacturer;
import com.gefa.manufacturer.client.exceptions.NotFoundException;
import com.gefa.manufacturer.client.exceptions.ServiceFailureException;

import java.net.URI;

public class ClientReadManufacturerActivity extends Activity {

	private final URI manufacturerURI;
	private Manufacturer manufacturer;
	private ManufacturerConverter manufacturerConverter =  new ManufacturerConverter();

	public ClientReadManufacturerActivity(URI manufacturerURI) {
		this.manufacturerURI = manufacturerURI;
	}

	public void readManufacturer() throws NotFoundException, ServiceFailureException {
			ManufacturerRepresentation manufacturerRepresentation = httpBinding.retrieveManufacturer(manufacturerURI);
			this.manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromRepresentation(manufacturerRepresentation);
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
}
