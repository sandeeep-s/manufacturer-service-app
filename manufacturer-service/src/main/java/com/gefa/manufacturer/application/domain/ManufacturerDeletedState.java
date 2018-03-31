package com.gefa.manufacturer.application.domain;

public class ManufacturerDeletedState extends ManufacturerState {

	private Manufacturer manufacturer;

	public ManufacturerDeletedState(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
