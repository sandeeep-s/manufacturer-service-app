package com.gefa.ekf.client;


import com.gefa.ekf.client.activities.Actions;
import com.gefa.ekf.client.activities.ClientCreateManufacturerActivity;
import com.gefa.ekf.client.activities.ClientReadManufacturerActivity;
import com.gefa.ekf.client.domain.Manufacturer;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.fit.domain.TestManufacturerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;


import java.net.URI;
import java.net.URISyntaxException;


public class FitTest {

    @BeforeClass
    public static void init() throws Exception {
//        MyServer.startContainer();
    }

    @AfterClass
    public static void stop() throws Exception {
  //      MyServer.stopContainer();

    }

/*
    private String getEntryPointURI() {
        String testPortProviderURL = TestPortProvider.generateURL("/fit-asset-service/asset");
        System.out.println("testPortProviderURL="+testPortProviderURL);
        return testPortProviderURL;
    }
*/

	private String getEntryPointURI() {
		return "http://localhost:8084/manufacturer-service/manufacturer";
	}

    @Test
    public void testCreateManufacturer() throws URISyntaxException, NotFoundException, ServiceFailureException {
        ClientCreateManufacturerActivity clientCreateManufacturerActivity = new ClientCreateManufacturerActivity();

        TestManufacturerFactory testManufacturerFactory = new TestManufacturerFactory();
        Manufacturer manufacturer = testManufacturerFactory.createManufacturer();

        clientCreateManufacturerActivity.createManufacturer(manufacturer, new URI(getEntryPointURI()));

        Manufacturer createdManufacturer = null;
        Actions actions = clientCreateManufacturerActivity.getActions();

        if (actions.has(ClientReadManufacturerActivity.class)) {
            ClientReadManufacturerActivity clientReadManufacturerActivity = actions.get(ClientReadManufacturerActivity.class);
            clientReadManufacturerActivity.readManufacturer();
            createdManufacturer = clientReadManufacturerActivity.getManufacturer();
            actions = clientReadManufacturerActivity.getActions();
        }
        Assert.assertEquals(manufacturer.getManufacturerName(), createdManufacturer.getManufacturerName());

    }


}
