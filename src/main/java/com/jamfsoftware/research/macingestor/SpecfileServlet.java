package com.jamfsoftware.research.macingestor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SpecfileServlet {

	@Value("${repository.url}")
	private String repositoryURL;

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestParam(value = "bundleId", required = false) String bundleId) {

		SpecfileRepository repository = new SpecfileRepository(repositoryURL);
		if (bundleId != null) {
			model.addAttribute("files", repository.getSpecfiles(bundleId));
		} else {
			model.addAttribute("files", repository.getSpecfiles());
		}
		return "index";
	}


}

