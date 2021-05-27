package com.bisoft.navi.common.interfaces;

import com.bisoft.navi.common.exceptions.GetTitleObjectException;

import java.util.List;

public interface IModelObject {
	String name();
	List<String> title() throws GetTitleObjectException, GetTitleObjectException;
	Iterable<List<String>> body();
	
	public class Fake implements IModelObject {
		
		private final String name;
		private final List<String> title;
		private final List<List<String>> columns;
		
		public Fake(String name, List<String> title, List<List<String>> columns) {
			this.name = name;
			this.title = title;
			this.columns = columns;
		}
		
		@Override
		public String name() {
			return name;
		}
		
		@Override
		public List<String> title() throws GetTitleObjectException {
			return title;
		}
		
		@Override
		public Iterable<List<String>> body() {
			return columns;
		}
	}
}
