package com.jamfsoftware.research.macingestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

@Controller
@RequestMapping("/specfiles")
public class SpecfileServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("files", specfiles());
		return "specfiles";
	}

	private Map<String, String> specfiles() {
		Map<String,String> country = new LinkedHashMap<>();

		// TODO: replace sample data
		country.put("US", "United States");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");

		String specfileRepository = "https://d2e3kgnhdeg083.cloudfront.net";
		Document specfileXML = getSpecfileXML(specfileRepository);

		return country;
	}

	public Document getSpecfileXML(String repository) {
		try {
			// get contents from repository
			URL url = new URL(repository);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("Accept", "application/xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document xml = db.parse(con.getInputStream());
			xml.getDocumentElement().normalize();

			con.disconnect();

			return xml;
		} catch(IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}

		return null;
	}
}
