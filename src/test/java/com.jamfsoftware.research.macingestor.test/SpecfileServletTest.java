package com.jamfsoftware.research.macingestor.test;

import org.junit.Test;
import org.w3c.dom.Document;

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

}