package com.gefa.manufacturer.client.activities;

import java.net.URI;

import com.gefa.manufacturer.client.domain.Manufacturer;
import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.client.representations.converters.ManufacturerConverter;
import com.gefa.manufacturer.client.exceptions.CannotUpdateManufacturerException;
import com.gefa.manufacturer.client.exceptions.MalformedManufacturerException;
import com.gefa.manufacturer.client.exceptions.NotFoundException;
import com.gefa.manufacturer.client.exceptions.ServiceFailureException;

public class ClientUpdateManufacturerActivity extends Activity {

	private final URI manufacturerURI;

	private Manufacturer manufacturer;

	private ManufacturerConverter manufacturerConverter;

	public ClientUpdateManufacturerActivity(URI manufacturerURI) {
		this.manufacturerURI = manufacturerURI;
	}

	public void updateManufacturer(Manufacturer manufacturer) {
		try {
			ManufacturerRepresentation manufacturerRepresentation = httpBinding.updateManufacturer(manufacturerConverter.fromManufacturer(manufacturer), manufacturerURI);
			this.manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromRepresentation(manufacturerRepresentation);
		} catch (MalformedManufacturerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotUpdateManufacturerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

}
