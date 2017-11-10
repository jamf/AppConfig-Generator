package com.jamfsoftware.research.macingestor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/specfiles")
public class SpecfileServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestParam(value = "bundleId", required = false) String bundleId) {
		SpecfileRepository repository = new SpecfileRepository("https://d2e3kgnhdeg083.cloudfront.net"); // todo: externalize variable
		if (bundleId != null) {
			model.addAttribute("files", repository.getSpecfiles(bundleId));
		} else {
			model.addAttribute("files", repository.getSpecfiles());
		}
		return "specfiles";
	}

}
