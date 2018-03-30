package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.client.representations.ManufacturerRepresentation;
import com.gefa.ekf.client.representations.converters.ManufacturerConverter;
import com.gefa.ekf.client.domain.Manufacturer;
import com.gefa.ekf.client.exceptions.CannotCancelException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;

public class ClientRemoveManufacturerActivity extends Activity {

    private final URI manufacturerURI;

    private Manufacturer manufacturer;

    private ManufacturerConverter manufacturerConverter;

    public ClientRemoveManufacturerActivity(URI manufacturerURI) {
        this.manufacturerURI = manufacturerURI;
    }

    public void removeManufacturer(Manufacturer manufacturer) {
        try {
            ManufacturerRepresentation manufacturerRepresentation = httpBinding.removeManufacturer(manufacturerURI);
            this.manufacturer = manufacturerConverter.toManufacturer(manufacturerRepresentation);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ServiceFailureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CannotCancelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

}
