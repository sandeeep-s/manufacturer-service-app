package com.gefa.manufacturer.application.domain;

public class ManufacturerCreatedState extends ManufacturerState {

    private Manufacturer manufacturer;

    public ManufacturerCreatedState(Manufacturer manufacturer) {

        this.manufacturer = manufacturer;
    }

    @Override
    public void moveToDeletedState() {

        manufacturer.setManufacturerState(new ManufacturerDeletedState(manufacturer));
    }

}
