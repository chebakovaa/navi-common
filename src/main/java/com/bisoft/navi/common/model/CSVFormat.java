package com.bisoft.navi.common.model;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;
import com.bisoft.navi.common.interfaces.ISavedFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
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
	
	@Override
	public Iterable<String> loadedData(InputStreamReader inp) throws GetTitleObjectException {
		try {
			inp.
			return Arrays.stream(inp.readLine().split(delimiter)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			throw new GetTitleObjectException("Get Title Object Fail");
		}
	}
	
	@Override
	public String extensionWithDot() {
		return "." + extension();
	}

	@Override
	public String extension() {
		return "csv";
	}
	
}