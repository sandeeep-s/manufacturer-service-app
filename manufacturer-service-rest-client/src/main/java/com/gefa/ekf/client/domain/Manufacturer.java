package com.gefa.ekf.client.domain;

public class Manufacturer {

    private Long id;
    private String manufacturerName;
    private String manufacturerStatus;

    public Manufacturer() {

    }

    public Manufacturer(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Manufacturer(Long id, String manufacturerName) {
        this.id = id;
        this.manufacturerName = manufacturerName;
    }

    public Manufacturer(Long id, String manufacturerName, String manufacturerStatus) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.manufacturerStatus = manufacturerStatus;
    }

    public Long getId() {
        return id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getManufacturerStatus() {
        return manufacturerStatus;
    }
}
