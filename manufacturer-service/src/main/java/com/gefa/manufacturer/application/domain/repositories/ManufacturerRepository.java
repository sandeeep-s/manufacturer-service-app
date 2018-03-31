package com.gefa.manufacturer.application.domain.repositories;

import java.util.List;

import com.gefa.manufacturer.application.domain.Manufacturer;

public interface ManufacturerRepository {

	Long saveManufacturer(Manufacturer manufacturer);

	void updateManufacturer(Manufacturer manufacturer);

	Manufacturer getManufacturer(Long manufacturerId);

	Boolean exists(Long manufacturerNumber);

}
