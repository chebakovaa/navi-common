package com.bisoft.navi.common.resources;

import com.bisoft.navi.common.exceptions.LoadResourceException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesResourceTest {
	
	@BeforeMethod
	public void setUp() {
	}
	
	@AfterMethod
	public void tearDown() {
	}
	
	@Test
	public void shouldLoadedResourceCorrectly() throws LoadResourceException {
	  Map<String, String> res = new FilesResource(new String[]{"string1.test"}, ".test").loadedResource();
		assertThat(res.size()).isEqualTo(1);
		assertThat(res.containsKey("string1")).isTrue();
		assertThat(res.get("string1")).hasToString("123 456\n789");
	}
}