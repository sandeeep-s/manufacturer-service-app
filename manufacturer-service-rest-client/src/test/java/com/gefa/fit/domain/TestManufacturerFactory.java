package com.gefa.fit.domain;

import com.gefa.ekf.client.domain.Manufacturer;

import java.util.concurrent.ThreadLocalRandom;

public class TestManufacturerFactory {

	public Manufacturer createManufacturer() {
		int random = ThreadLocalRandom.current().nextInt(10000, 30000);

		String manufacturerName = "JMSTEST-" + random;
		return new Manufacturer(manufacturerName);

	}

}
