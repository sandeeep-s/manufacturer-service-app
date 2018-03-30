package com.gefa.ekf.client.representations;

import java.net.URI;
import java.net.URISyntaxException;

public class Link {
	private String rel;
	private String uri;
	private String mediaType;

	/**
	 * For JAXB :-(
	 */
	Link() {
	}

	public Link(String name, String uri, String mediaType) {
		this.rel = name;
		this.uri = uri;
		this.mediaType = mediaType;

	}

	public String getRel() {
		return rel;
	}

	public URI getUri() {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public String getMediaType() {
		return mediaType;
	}

}
