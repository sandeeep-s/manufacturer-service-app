package com.gefa.fit.boundary.inbound.rest.error;

import java.util.EnumMap;

public enum ErrorCodeNum {

	RESOORCE_NOT_FOUND("2001"), INTERNAL_ERROR("2002");

	private String appError;

	private static EnumMap<ErrorCodeNum, String> enumMap;

	ErrorCodeNum(String appError) {
		this.appError = appError;
	}

	public String getApplicationError() {
		return appError;
	}

	public String getUserMessage() {
		return enumMap.get(this);
	}

	static {
		enumMap = new EnumMap<>(ErrorCodeNum.class);
		enumMap.put(RESOORCE_NOT_FOUND, "The requested Resource was not found on the server.");
		enumMap.put(INTERNAL_ERROR, "Internal Server Error.");
	}

}
