package com.bisoft.navi.common.resources;

import com.bisoft.navi.App;
import com.bisoft.navi.common.exceptions.LoadConnectionParameterException;
import com.bisoft.navi.common.interfaces.ITypedResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class XMLResource  implements ITypedResource<Map<String, String>> {

	private final InputStream stream;
	
	public XMLResource(InputStream stream) {
		this.stream = stream;
	}

	@Override
	public Map<String, String> loadedResource() throws LoadConnectionParameterException {
		Map<String, String> result = new HashMap<>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = null;
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(stream);
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getElementsByTagName("query");
			for(int nodeIndex = 0; nodeIndex < nodes.getLength(); nodeIndex++){
				Node node = nodes.item(nodeIndex);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String id = eElement.getAttribute("id");
					String nn = eElement.getTextContent();
					result.put(id, nn);
				}
			}
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
			throw new LoadConnectionParameterException("Loading CQL Fail.");
		}
		return result;
	}
}
