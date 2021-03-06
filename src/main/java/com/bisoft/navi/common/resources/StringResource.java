package com.bisoft.navi.common.resources;

import com.bisoft.navi.App;
import com.bisoft.navi.common.interfaces.ITypedResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class StringResource implements ITypedResource<String> {
	private final String resourceName;
	
	public StringResource(String resourceName) {
		this.resourceName = resourceName;
	}
	
	@Override
	public String loadedResource() {
		InputStream queryStream = App.class.getClassLoader().getResourceAsStream(resourceName);
		return new BufferedReader(
			new InputStreamReader(queryStream, StandardCharsets.UTF_8))
			.lines()
			.collect(Collectors.joining("\n"));
	}
	
}
