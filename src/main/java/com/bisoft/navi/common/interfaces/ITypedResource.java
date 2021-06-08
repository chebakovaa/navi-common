package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;
import com.bisoft.navi.common.exceptions.LoadResourceException;

public interface ITypedResource<T> {
	T loadedResource() throws LoadConnectionParameterException, LoadResourceException;
}
