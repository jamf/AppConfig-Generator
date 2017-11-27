package com.jamfsoftware.research.macingestor.test;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.jamfsoftware.research.macingestor.Specfile;
import com.jamfsoftware.research.macingestor.SpecfileRepository;
import com.jamfsoftware.research.macingestor.SpecfileServlet;

public class SpecfileServletTest {

//	@Test
//	public void testNonexistentRepository() {
//		try {
//			String specfileRepository = "https://nothing.example.com";
//			Document xml = new SpecfileServlet().getSpecfileXML(specfileRepository);
//			String rootElement = xml.getDocumentElement().getNodeName();
//		} catch(Exception e) {
//			assert true;
//		}
//		assert false;
//	}

	@Test
	public void testGetSpecfiles() {
		String specfileRepositoryURL = "https://d2e3kgnhdeg083.cloudfront.net";
		SpecfileRepository repository = new SpecfileRepository(specfileRepositoryURL);
		Document xml = repository.getSpecfileXML(specfileRepositoryURL);

		String rootElement = xml.getDocumentElement().getNodeName();
		System.out.println(rootElement);

		assert rootElement.equals("ListBucketResult");
	}


	@Test
	public void testSpecfilesExist() {
		String specfileRepositoryURL = "https://d2e3kgnhdeg083.cloudfront.net";
		SpecfileRepository repository = new SpecfileRepository(specfileRepositoryURL);
		Document specfileXML = repository.getSpecfileXML(specfileRepositoryURL);
		NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");

		assert list.getLength() > 0;
	}

	@Test
	public void testGetXML() {

	}
}