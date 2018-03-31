package com.gefa.manufacturer.client.representations.converters;


import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;
import com.gefa.manufacturer.client.domain.Manufacturer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ManufacturerConverter {

    public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation) {

        return new Manufacturer(manufacturerRepresentation.getId(),
                manufacturerRepresentation.getManufacturerName());

    }

    public Manufacturer toManufacturer(ManufacturerRepresentation manufacturerRepresentation, Long manufacturerId) {
        return new Manufacturer(manufacturerId, manufacturerRepresentation.getManufacturerName());

    }

    public ManufacturerRepresentation fromManufacturer(Manufacturer manufacturer) {

        return new ManufacturerRepresentation(manufacturer);
    }

}
