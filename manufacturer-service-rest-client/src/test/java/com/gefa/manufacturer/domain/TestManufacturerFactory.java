package com.gefa.manufacturer.domain;

import com.gefa.manufacturer.client.domain.Manufacturer;

import java.util.concurrent.ThreadLocalRandom;

public class TestManufacturerFactory {

	public Manufacturer createManufacturer() {
		int random = ThreadLocalRandom.current().nextInt(10000, 30000);

		String manufacturerName = "TestMan-" + random;
		return new Manufacturer(manufacturerName);

	}

}
