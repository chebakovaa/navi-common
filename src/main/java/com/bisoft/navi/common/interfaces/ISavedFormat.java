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
	
	public class Fake implements ISavedFormat {
		
		@Override
		public void save(OutputStreamWriter out, Iterable<String> row) throws IOException {
		
		}
		
		@Override
		public Iterable<String> loadedTitles(InputStream inp) throws GetTitleObjectException {
			return null;
		}
		
		@Override
		public String extensionWithDot() {
			return null;
		}
		
		@Override
		public String extension() {
			return null;
		}
	}
}
