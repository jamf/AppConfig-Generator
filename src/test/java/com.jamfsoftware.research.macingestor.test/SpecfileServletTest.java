package com.jamfsoftware.research.macingestor.test;

import org.junit.Test;

import com.jamfsoftware.research.macingestor.SpecfileServlet;

public class SpecfileServletTest {

	@Test
	public void exampleTest() {
		assert true;
	}

	@Test
	public void testGetURL() {
		String response = new SpecfileServlet().getRequest();
		System.out.println(response);
	}

}