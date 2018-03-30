package com.gefa.fit.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.fit.application.domain.Manufacturer;
import com.gefa.fit.application.domain.ManufacturerCreatedState;
import com.gefa.fit.application.domain.events.ManufacturerCreatedEvent;
import com.gefa.fit.application.domain.events.DomainEvent;
import com.gefa.fit.application.domain.repositories.MapManufacturerRepository;
import com.gefa.fit.application.exceptions.ManufacturerCreationException;
import com.gefa.fit.application.exceptions.ManufacturerRemovalException;
import com.gefa.fit.application.exceptions.ManufacturerUpdateException;
import com.gefa.fit.application.infrastructure.RXDomainEventsDispatcher;

@ApplicationScoped
public class ManufacturerService {

    @Inject
    private MapManufacturerRepository manufacturerRepository;
    // private ManufacturerRepository manufacturerRepository;

    @Inject
    private RXDomainEventsDispatcher domainEventsDispatcher;

    public Long create(Manufacturer manufacturer) {

        Long manufacturerId;
        try {
            manufacturer.setManufacturerState(new ManufacturerCreatedState(manufacturer));
            manufacturerId = manufacturerRepository.saveManufacturer(manufacturer);
            manufacturer.addDomainEvent(new ManufacturerCreatedEvent(manufacturer));
            for (DomainEvent domainEvent : manufacturer.getDomainEvents()) {
                domainEventsDispatcher.dispatch(domainEvent);
            }
        } catch (Exception e) {
            throw new ManufacturerCreationException();
        }

        return manufacturerId;
    }

    public void update(Manufacturer manufacturer) {

        try{
            Manufacturer manufacturerFromRepo = manufacturerRepository.getManufacturer(manufacturer.getId());
            manufacturerFromRepo.moveToCreatedState();
            manufacturerRepository.updateManufacturer(manufacturer);

        }catch(UnsupportedOperationException e){
            throw new ManufacturerUpdateException();
        }catch(Exception e){
            throw new ManufacturerUpdateException();
        }

        // TODO Update the assetFromRepo details onto manufacturer
    }

    public Manufacturer getManufacturer(Long assetId) {
        return manufacturerRepository.getManufacturer(assetId);
    }

    public Manufacturer removeManufacturer(Long assetId) {
        try {
            Manufacturer manufacturer = manufacturerRepository.getManufacturer(assetId);
            manufacturer.moveToDeletedState();
            return manufacturerRepository.delete(assetId);
        } catch (UnsupportedOperationException e) {
            throw new ManufacturerRemovalException();
        }

    }

}
