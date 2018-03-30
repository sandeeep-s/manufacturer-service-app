package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.client.domain.Manufacturer;
import com.gefa.ekf.client.representations.ManufacturerRepresentation;
import com.gefa.ekf.client.representations.converters.ManufacturerConverter;
import com.gefa.ekf.client.exceptions.CannotUpdateManufacturerException;
import com.gefa.ekf.client.exceptions.MalformedManufacturerException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

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
