package com.bisoft.navi.common.model;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class CSVFormatTest {
	
	@Test
	public void shouldSaveWorkCorrectly() throws IOException {

		CSVFormat format = new CSVFormat("|");
		assertThat(format.extension()).hasToString("csv");
		assertThat(format.extensionWithDot()).hasToString(".csv");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStreamWriter stm = new OutputStreamWriter(baos, "UTF8");
		format.save(stm, List.of("111", "112", "113"));
		stm.close();
		
		assertThat(baos).hasToString("111|112|113\r\n");
		
	}

	@Test
	public void shouldLoadTitlesWorkCorrectly() throws IOException, GetTitleObjectException {
		
		CSVFormat format = new CSVFormat("|");
		String initialString = "111|112|113\r\n211|212|213\r\n";
		InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
		Iterable<String> title = format.loadedTitles(targetStream);
		String[] result = StreamSupport.stream(title.spliterator(), false).toArray(String[]::new);
		assertThat(result.length).isEqualTo(3);
		assertThat(result[2]).isEqualTo("113");
		
	}
	
}
