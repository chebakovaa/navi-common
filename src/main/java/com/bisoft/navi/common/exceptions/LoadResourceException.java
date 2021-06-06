package com.bisoft.navi.common.exceptions;

public class LoadResourceException   extends Exception {
    public LoadResourceException(String errorMessage, Throwable ex){
        super(errorMessage, ex);
    }
}
