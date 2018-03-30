package com.gefa.ekf.client.representations;

import java.util.List;

public abstract class Representation {

	public static final String SELF_REL_VALUE = "self";

	protected List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	protected Link getLinkByName(String uriName) {
		if (links == null) {
			return null;
		}

		for (Link l : links) {
			if (l.getRel().toLowerCase().equals(uriName.toLowerCase())) {
				return l;
			}
		}
		return null;
	}

}
