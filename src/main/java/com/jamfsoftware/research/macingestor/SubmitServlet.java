package com.jamfsoftware.research.macingestor;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dd.plist.NSDictionary;
import com.jamfsoftware.research.macingestor.jaxb.ManagedAppConfiguration;

@Controller
@RequestMapping("/submit")
public class SubmitServlet {

	@RequestMapping(value = "/download", method = RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String download(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/force-download");
		response.addHeader("Content-Disposition","attachment; filename=\"mac.plist\"");
		Reader reader = new StringReader(generatePlist(request));
		try {
			IOUtils.copy(reader, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String submit(HttpServletRequest request, HttpServletResponse response) {

		String plist = generatePlist(request);
		request.setAttribute("plist", plist);

		ManagedAppConfiguration mac = (ManagedAppConfiguration) request.getSession().getAttribute("mac");
		request.setAttribute("specfile", mac.getBundleId() + "/" + mac.getVersion());

		return "submit";
	}
	
	private String generatePlist(HttpServletRequest request){
		ManagedAppConfiguration mac = (ManagedAppConfiguration)request.getSession().getAttribute("mac");
		NSDictionary plist = new NSDictionary();
		for(Object o : mac.getDict().getStringOrStringArrayOrInteger()){
			MACDataType data = (MACDataType)o;
			plist.put(data.getKeyName(), data.getPlistObject(request.getParameterValues(data.getKeyName())));
		}
		return plist.toXMLPropertyList();
	}

}
