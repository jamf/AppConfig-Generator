package com.jamfsoftware.research.macingestor.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.jamfsoftware.research.macingestor.Specfile;
import com.jamfsoftware.research.macingestor.SpecfileRepository;
import com.jamfsoftware.research.macingestor.SpecfileServlet;

public class SpecfileServletTest {

	private String testRepositoryURL = "https://d2e3kgnhdeg083.cloudfront.net";

	@Test
	public void testNonexistentRepository() {
		boolean failed = false;
		try {
			String specfileRepositoryURL = "https://repository.example.com";
			SpecfileRepository repository = new SpecfileRepository(specfileRepositoryURL);
			Document xml = repository.getSpecfileXML();
			String rootElement = xml.getDocumentElement().getNodeName();
		} catch(Exception e) {
			failed = true;
		}
		assert failed; // it's supposed to fail
	}

	@Test
	public void testGetSpecfiles() {
		SpecfileRepository repository = new SpecfileRepository(testRepositoryURL);
		Document xml = repository.getSpecfileXML();

		String rootElement = xml.getDocumentElement().getNodeName();
		System.out.println(rootElement);

		assert rootElement.equals("ListBucketResult");
	}


	@Test
	public void testSpecfilesExist() {
		SpecfileRepository repository = new SpecfileRepository(testRepositoryURL);
		Document specfileXML = repository.getSpecfileXML();
		NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");

		assert list.getLength() > 0;
	}

}