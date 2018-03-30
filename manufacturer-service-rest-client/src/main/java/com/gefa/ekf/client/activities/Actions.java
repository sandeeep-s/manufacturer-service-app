package com.gefa.ekf.client.activities;

import java.util.ArrayList;

public class Actions extends ArrayList<Activity> {

	public boolean has(Class clazz) {
		for (Activity activity : this) {
			if (activity.getClass() == clazz) {
				return true;
			}
		}

		return false;
	}

	public <T extends Activity> T get(Class clazz) {

		for (Activity activity : this) {
			if (activity.getClass() == clazz) {
				return (T) clazz.cast(activity);
			}
		}

		return null;
	}

}
