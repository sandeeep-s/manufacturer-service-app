package com.gefa.manufacturer.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.manufacturer.application.domain.Manufacturer;
import com.gefa.manufacturer.application.domain.ManufacturerCreatedState;
import com.gefa.manufacturer.application.domain.events.ManufacturerCreatedEvent;
import com.gefa.manufacturer.application.domain.events.DomainEvent;
import com.gefa.manufacturer.application.domain.repositories.MapManufacturerRepository;
import com.gefa.manufacturer.application.exceptions.ManufacturerCreationException;
import com.gefa.manufacturer.application.exceptions.ManufacturerRemovalException;
import com.gefa.manufacturer.application.exceptions.ManufacturerUpdateException;
import com.gefa.manufacturer.application.infrastructure.RXDomainEventsDispatcher;

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

        // TODO Update the manufacturerFromRepo details onto manufacturer
    }

    public Manufacturer getManufacturer(Long manufacturerId) {
        return manufacturerRepository.getManufacturer(manufacturerId);
    }

    public Manufacturer removeManufacturer(Long manufacturerId) {
        try {
            Manufacturer manufacturer = manufacturerRepository.getManufacturer(manufacturerId);
            manufacturer.moveToDeletedState();
            return manufacturerRepository.delete(manufacturerId);
        } catch (UnsupportedOperationException e) {
            throw new ManufacturerRemovalException();
        }

    }

}
