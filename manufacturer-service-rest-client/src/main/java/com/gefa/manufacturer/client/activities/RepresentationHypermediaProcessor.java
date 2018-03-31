package com.gefa.manufacturer.client.activities;


import com.gefa.manufacturer.client.representations.ManufacturerRepresentation;

public class RepresentationHypermediaProcessor {

	Actions extractNextActionsFromRepresentation(ManufacturerRepresentation manufacturerRepresentation) {

		Actions actions = new Actions();

		if (null != manufacturerRepresentation) {
			if (null != manufacturerRepresentation.getSelfLink()) {
				actions.add(new ClientReadManufacturerActivity(manufacturerRepresentation.getSelfLink().getUri()));
			}

			if (null != manufacturerRepresentation.getUpdateLink()) {
				actions.add(new ClientUpdateManufacturerActivity(manufacturerRepresentation.getUpdateLink().getUri()));
			}

			if (null != manufacturerRepresentation.getRemoveLink()) {
				actions.add(new ClientRemoveManufacturerActivity(manufacturerRepresentation.getRemoveLink().getUri()));
			}
		}

		return actions;

	}


}
