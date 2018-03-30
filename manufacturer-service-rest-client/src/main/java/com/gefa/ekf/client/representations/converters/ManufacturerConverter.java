package com.gefa.ekf.client.representations.converters;


import com.gefa.ekf.client.representations.ManufacturerRepresentation;
import com.gefa.ekf.client.domain.Manufacturer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManufacturerConverter {

    public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation) {

        return new Manufacturer(manufacturerRepresentation.getId(),
                manufacturerRepresentation.getManufacturerName());

    }

    public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation, Long assetId) {
        return new Manufacturer(assetId, manufacturerRepresentation.getManufacturerName());

    }

    public ManufacturerRepresentation fromManufacturer(Manufacturer manufacturer) {

        return new ManufacturerRepresentation(manufacturer);
    }

}
