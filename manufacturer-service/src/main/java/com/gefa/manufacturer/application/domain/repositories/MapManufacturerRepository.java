package com.gefa.manufacturer.application.domain.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import com.gefa.manufacturer.application.domain.Manufacturer;

@Singleton
public class MapManufacturerRepository implements ManufacturerRepository {

	/*
	 * private static final MapManufacturerRepository thisRepository = new
	 * MapManufacturerRepository();
	 * 
	 * public static MapManufacturerRepository current() { return thisRepository; }
	 */
	private Map<Long, Manufacturer> backingStore = new HashMap<Long, Manufacturer>();

	public Long save(Manufacturer manufacturer) {
		int size = backingStore.size();
		Long id = Long.valueOf(size + 1);
		backingStore.put(id, manufacturer);
		return id;
	}

	public Long update(Manufacturer manufacturer, Long id) {
		backingStore.put(id, manufacturer);
		return id;
	}

	public Manufacturer find(Long id) {
		return backingStore.get(id);
	}

	public Manufacturer delete(Long id) {
		Manufacturer manufacturer = backingStore.remove(id);
		return manufacturer;
	}

	@Override
	public Long saveManufacturer(Manufacturer manufacturer) {
		int size = backingStore.size();
		Long id = Long.valueOf(size + 1);
		backingStore.put(id, manufacturer);
		return id;

	}

	@Override
	public void updateManufacturer(Manufacturer manufacturer) {
		backingStore.put(manufacturer.getId(), manufacturer);
	}

	@Override
	public Manufacturer getManufacturer(Long manufacturerId) {
		return backingStore.get(manufacturerId);
	}

	@Override
	public Boolean exists(Long manufacturerNumber) {

		return null;
	}


}
