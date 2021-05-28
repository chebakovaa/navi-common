package com.bisoft.navi.common.resources;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;
import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;
import com.bisoft.navi.common.model.CSVFormat;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class XMLResourceTest {
	
	@Test
	public void shouldLoadWorkCorrectly() throws IOException, LoadConnectionParameterException {
		
		String initialString = "<?xml version=\"1.0\"?>\n" +
			"<queries>\n" +
			"    <query id=\"1\">" +
			"111 222 333 444" +
			"</query>\n" +
			"    <query id=\"2\">" +
			"555 666 777 888" +
			"</query>\n" +
			"</queries>";
		
		InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
		
		XMLResource res = new XMLResource(targetStream);
		Map<String, String> queries = res.loadedResource();
		
		assertThat(queries.size()).isEqualTo(2);
		assertThat(queries.containsKey("2")).isTrue();
		assertThat(queries.get("2")).hasToString("555 666 777 888");
		
	}
	
}

