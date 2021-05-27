package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public interface ISavedFormat {
	
	void save(OutputStreamWriter out, Iterable<String> row) throws IOException;
	
	Iterable<String> loadedTitles(InputStream inp) throws GetTitleObjectException;
	
	String extensionWithDot();
	
	String extension();
}
