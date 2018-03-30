package com.gefa.fit.application.domain.repositories;

import java.util.List;

import com.gefa.fit.application.domain.Manufacturer;

public interface ManufacturerRepository {

	Long saveManufacturer(Manufacturer manufacturer);

	void updateManufacturer(Manufacturer manufacturer);

	Manufacturer getManufacturer(Long assetId);

	Boolean exists(Long manufacturerNumber);

}
