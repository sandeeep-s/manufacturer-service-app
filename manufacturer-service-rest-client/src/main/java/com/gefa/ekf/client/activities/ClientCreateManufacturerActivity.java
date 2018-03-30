package com.gefa.ekf.client.activities;

import com.gefa.ekf.client.representations.ManufacturerRepresentation;
import com.gefa.ekf.client.representations.converters.ManufacturerConverter;
import com.gefa.ekf.client.domain.Manufacturer;
import com.gefa.ekf.client.exceptions.MalformedManufacturerException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

import java.net.URI;

public class ClientCreateManufacturerActivity extends Activity {

	private Manufacturer manufacturer;

	private ManufacturerConverter manufacturerConverter = new ManufacturerConverter();

	public void createManufacturer(Manufacturer manufacturer, URI manufacturerURI) {

		try {
			ManufacturerRepresentation manufacturerRepresentation = httpBinding.createManufacturer(manufacturerConverter.fromManufacturer(manufacturer), manufacturerURI);
			this.manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromRepresentation(manufacturerRepresentation);

		} catch (MalformedManufacturerException e) {
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			e.printStackTrace();
		}

	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

}
