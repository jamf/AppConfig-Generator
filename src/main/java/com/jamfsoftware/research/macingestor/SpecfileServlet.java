package com.jamfsoftware.research.macingestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
@RequestMapping("/specfiles")
public class SpecfileServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestParam(value = "bundleId", required = false) String bundleId) {
		if (bundleId != null) {
			model.addAttribute("files", specfiles(bundleId));
		} else {
			model.addAttribute("files", specfiles());
		}
		return "specfiles";
	}

	private List<Specfile> specfiles(String bundleId) {
		List<Specfile> allSpecfiles = specfiles();
		List<Specfile> specificSpecfiles = new ArrayList<>();

		// only return specfiles corresponding to that bundle id
		for(Specfile s : allSpecfiles) {
			if (s.getBundleId().equals(bundleId)) {
				specificSpecfiles.add(s);
			}
		}

		return specificSpecfiles;
	}

	private List<Specfile> specfiles() {
		String specfileRepository = "https://d2e3kgnhdeg083.cloudfront.net"; // todo externalize variable
		Document specfileXML = getSpecfileXML(specfileRepository); // todo handle this being null on failure to obtain repository contents
		NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");

		// iterate through the 'Contents' nodes
		List<Specfile> specfiles = new ArrayList<>();
		for(int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			// example 'Contents' element: <Contents><Key>com.bundle.id/specfileVersion/appconfig.xml</Key></Contents>
			String specfileName = n.getFirstChild().getFirstChild().getNodeValue();
			String[] specfileNameSegments = specfileName.split("/"); // split bundle id and specfile version

			String specfileResourceLocation = specfileRepository + "/" + specfileName;
			String specfileBundleId = specfileNameSegments[0];
			String specfileVersion = specfileNameSegments[1];

			Specfile specfile = new Specfile(specfileBundleId, specfileVersion, specfileResourceLocation);
			specfiles.add(specfile);
		}

		Collections.sort(specfiles, new SpecfileComparator());
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
			con.disconnect();

			return xml;
		} catch(IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}

		return null;
	}
}
