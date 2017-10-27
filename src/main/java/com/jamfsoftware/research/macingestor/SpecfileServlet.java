package com.jamfsoftware.research.macingestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
@RequestMapping("/specfiles")
public class SpecfileServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("files", specfiles());
		return "specfiles";
	}

	private List<Specfile> specfiles() {
//		Map<String,String> specfiles = new LinkedHashMap<>();

//		// TODO: replace sample data
//		country.put("US", "United States");
//		country.put("CHINA", "China");
//		country.put("SG", "Singapore");
//		country.put("MY", "Malaysia");

		String specfileRepository = "https://d2e3kgnhdeg083.cloudfront.net";
		Document specfileXML = getSpecfileXML(specfileRepository);
		NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");

		List<Specfile> specfiles = new ArrayList<>();
		for(int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			// value of <Key> element: <Contents><Key>com.bundle.id</Key></Contents>
			String specfileName = n.getFirstChild().getFirstChild().getNodeValue();
			String[] specfileNameSegments = specfileName.split("/");
			//			System.out.println(Arrays.toString(specfileNameSegments));

			String specfileResourceLocation = specfileRepository + "/" + specfileName;
			String specfileBundleId = specfileNameSegments[0];
			String specfileVersion = specfileNameSegments[1];

			Specfile specfile = new Specfile(specfileBundleId, specfileVersion, specfileResourceLocation);
			specfiles.add(specfile);
		}

		return specfiles;
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
//			xml.getDocumentElement().normalize();

			con.disconnect();

			return xml;
		} catch(IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}

		return null;
	}
}
