package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;

public interface ITypedResource<T> {
	T loadedResource() throws LoadConnectionParameterException;
}
