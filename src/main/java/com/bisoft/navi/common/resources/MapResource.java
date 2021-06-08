package com.bisoft.navi.common.resources;

import com.bisoft.navi.App;
import com.bisoft.navi.common.exceptions.LoadResourceException;
import com.bisoft.navi.common.interfaces.ITypedResource;
import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class MapResource implements ITypedResource<Map<String, String>> {
    private final String resourceName;

    public MapResource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public Map<String, String> loadedResource() throws LoadResourceException {
        Map<String, String> result = new HashMap<>();
        Properties property = new Properties();
        try(InputStream is = App.class.getClassLoader().getResourceAsStream(resourceName)){
            property.load(is);
            property.forEach(
              (k, v) -> result.put((String)k, (String)v)
            );
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LoadResourceException(
              String.format("Loading resource from %s fail", resourceName), ex);
        }
        return result;
    }
}
