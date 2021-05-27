package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public interface ISavedFormat {
	
	void save(OutputStreamWriter out, Iterable<String> row) throws IOException;
	
	Iterable<String> loadedData(InputStreamReader inp) throws GetTitleObjectException;
	
	String extensionWithDot();
	
	String extension();
}
