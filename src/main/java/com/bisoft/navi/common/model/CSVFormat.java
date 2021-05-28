package com.bisoft.navi.common.model;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;
import com.bisoft.navi.common.interfaces.ISavedFormat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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
	public Iterable<String> loadedTitles(InputStream inp) throws GetTitleObjectException {
		List<String> titles = new ArrayList<>();
		try(Scanner scn = new Scanner(new BufferedInputStream(inp))) {
			titles = List.of(scn.nextLine().split(String.format("\\%s",delimiter)));
		}
		return titles;
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