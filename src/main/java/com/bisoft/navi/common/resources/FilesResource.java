package com.bisoft.navi.common.resources;

import com.bisoft.navi.App;
import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;
import com.bisoft.navi.common.exceptions.LoadResourceException;
import com.bisoft.navi.common.interfaces.ITypedResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public final class FilesResource implements ITypedResource<Map<String, String>> {
	private final String[] resourceNames;
	private final String prefix;
	
	public FilesResource(String[] resourceNames, String prefix) {
		this.resourceNames = resourceNames;
		this.prefix = prefix;
	}
	
	@Override
	public Map<String, String> loadedResource() throws LoadResourceException {
		Map<String, String> result = new HashMap<>();
		for(String resourceName: resourceNames) {
			try(InputStream queryStream = App.class.getClassLoader().getResourceAsStream(resourceName)){
				if (queryStream == null) {
					throw new IOException();
				}
				String val = new BufferedReader(
					new InputStreamReader(queryStream, StandardCharsets.UTF_8))
					.lines()
					.collect(Collectors.joining("\n"));
				result.put(resourceName.replace(prefix, ""), val);
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new LoadResourceException(
					String.format("Load resource from %s fail", resourceName),
					ex
				);
			}
		}
		return result;
	}
	
}