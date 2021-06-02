package com.bisoft.navi.common.exceptions;

public final class DBConnectionException extends Exception {
	public DBConnectionException(final String errorMessage, final Throwable cause){
		super(errorMessage, cause);
	}
}

