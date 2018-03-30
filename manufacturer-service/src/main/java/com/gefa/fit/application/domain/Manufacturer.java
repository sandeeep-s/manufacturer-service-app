package com.gefa.fit.application.domain;

public class Manufacturer extends AggregateRoot {

	private Long id;
	private String manufacturerName;
	private ManufacturerState manufacturerState;

	public Manufacturer(String manufacturerName) {
		super();
		this.manufacturerName = manufacturerName;
	}

	public Manufacturer(Long id, String manufacturerName) {
		super();
		this.id = id;
		this.manufacturerName = manufacturerName;
	}

	public Long getId() {
		return id;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public ManufacturerState getManufacturerState() {
		return manufacturerState;
	}

	public void setManufacturerState(ManufacturerState manufacturerState) {
		this.manufacturerState = manufacturerState;
	}

	public void moveToCreatedState() {
		manufacturerState.moveToCreatedState();
	}

	public void moveToDeletedState() {
		manufacturerState.moveToDeletedState();
	}

}
