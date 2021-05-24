package com.bisoft.navi.common.model;

import com.bisoft.navi.common.interfaces.ISavedFormat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CSVFormat implements ISavedFormat {
	
	private final String delimiter;
	
	public CSVFormat(String delimiter){
		this.delimiter = delimiter;
	}
	
	@Override
	public void save(OutputStreamWriter out, Iterable<String> row) throws IOException {
		out.write(StreamSupport.stream(row.spliterator(), false).collect(Collectors.joining(delimiter)) + "\r\n");
	}
	
}