package com.jamfsoftware.research.macingestor.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jamfsoftware.research.macingestor.Specfile;
import com.jamfsoftware.research.macingestor.SpecfileServlet;

public class SpecfileServletTest {

	@Test
	public void testGetSpecfiles() {
		String specfileRepository = "https://d2e3kgnhdeg083.cloudfront.net";
		Document xml = new SpecfileServlet().getSpecfileXML(specfileRepository);

		String rootElement = xml.getDocumentElement().getNodeName();
		System.out.println(rootElement);

		assert rootElement.equals("ListBucketResult");
	}


	@Test
	public void testSpecfilesExist() {
		String specfileRepository = "https://d2e3kgnhdeg083.cloudfront.net";
		Document specfileXML = new SpecfileServlet().getSpecfileXML(specfileRepository);
		NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");

		assert list.getLength() > 0;
	}
}