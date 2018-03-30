package com.gefa.ekf.client.activities;

import com.gefa.ekf.client.representations.ManufacturerRepresentation;
import com.gefa.ekf.client.representations.converters.ManufacturerConverter;
import com.gefa.ekf.client.domain.Manufacturer;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

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
