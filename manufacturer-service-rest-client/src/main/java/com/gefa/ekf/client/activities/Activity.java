package com.gefa.ekf.client.activities;

import com.gefa.ekf.client.network.HttpBinding;

public class Activity {

	protected final HttpBinding httpBinding = new HttpBinding();

	protected Actions actions;

	public Actions getActions() {
		return actions;
	}
}
