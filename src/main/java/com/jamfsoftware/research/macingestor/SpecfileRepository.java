package com.jamfsoftware.research.macingestor;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SpecfileRepository {

	private String repositoryURL;

	public SpecfileRepository(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}

	public List<Specfile> getSpecfiles(String bundleId) {
		List<Specfile> allSpecfiles = getSpecfiles();
		List<Specfile> specificSpecfiles = new ArrayList<>();

		// only return specfiles corresponding to that bundle id
		for(Specfile s : allSpecfiles) {
			if (s.getBundleId().equals(bundleId)) {
				specificSpecfiles.add(s);
			}
		}

		return specificSpecfiles;
	}

	public List<Specfile> getSpecfiles() {
		List<Specfile> specfiles = new ArrayList<>();

		Document specfileXML = getSpecfileXML();
		if (specfileXML != null) {
			NodeList list = specfileXML.getDocumentElement().getElementsByTagName("Contents");
			// iterate through the 'Contents' nodes
			for(int i = 0; i < list.getLength(); i++) {
				Node n = list.item(i);

				// example 'Contents' element: <Contents><Key>com.bundle.id/specfileVersion/appconfig.xml</Key></Contents>
				String specfileName = n.getFirstChild().getFirstChild().getNodeValue();
				String[] specfileNameSegments = specfileName.split("/"); // split bundle id and specfile version

				String specfileResourceLocation = repositoryURL + "/" + specfileName;
				String specfileBundleId = specfileNameSegments[0];
				String specfileVersion = specfileNameSegments[1];

				Specfile specfile = new Specfile(specfileBundleId, specfileVersion, specfileResourceLocation);
				specfiles.add(specfile);
			}
			Collections.sort(specfiles, new SpecfileComparator()); // sort using our custom SpecfileComparator
		}
		return specfiles; // returns empty list if repository does not contain any specfiles
	}

	public Document getSpecfileXML() {
		try {
			// get contents from repository
			URL url = new URL(repositoryURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("Accept", "application/xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document xml = db.parse(con.getInputStream());
			con.disconnect();

			return xml;
		} catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean validSpecfile(String file) {
		boolean valid = false;
		for(Specfile s : getSpecfiles()) {
			if (s.getResourceLocation().equals(file)) {
				valid = true;
			}
		}
		return valid;
	}

}
