package com.gefa.manufacturer.client.activities;

import com.gefa.manufacturer.client.network.HttpBinding;

public class Activity {

	protected final HttpBinding httpBinding = new HttpBinding();

	protected Actions actions;

	public Actions getActions() {
		return actions;
	}
}
