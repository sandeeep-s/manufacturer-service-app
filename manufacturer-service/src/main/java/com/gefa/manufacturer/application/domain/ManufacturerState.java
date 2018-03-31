package com.gefa.manufacturer.application.domain;

public abstract class ManufacturerState {

    public enum StatusCode {
        CREATED, DELETED
    }

    private StatusCode statusCode;


    public void moveToCreatedState() {
        throw new UnsupportedOperationException();
    }

    public void moveToDeletedState() {
        throw new UnsupportedOperationException();
    }
}
