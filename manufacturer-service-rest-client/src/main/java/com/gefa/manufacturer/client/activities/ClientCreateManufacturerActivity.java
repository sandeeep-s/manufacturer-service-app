package com.gefa.manufacturer.client.activities;

import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.client.representations.converters.ManufacturerConverter;
import com.gefa.manufacturer.client.domain.Manufacturer;
import com.gefa.manufacturer.client.exceptions.MalformedManufacturerException;
import com.gefa.manufacturer.client.exceptions.ServiceFailureException;

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
