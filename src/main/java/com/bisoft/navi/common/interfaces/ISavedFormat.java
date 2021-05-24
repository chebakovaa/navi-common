package com.bisoft.navi.common.interfaces;

import java.io.IOException;
import java.io.OutputStreamWriter;

public interface ISavedFormat {
	void save(OutputStreamWriter out, Iterable<String> row) throws IOException;
}
