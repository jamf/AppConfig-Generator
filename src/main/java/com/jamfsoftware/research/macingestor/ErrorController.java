package com.jamfsoftware.research.macingestor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "errors")
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "Something went wrong.";

		int httpErrorCode = getErrorCode(httpRequest);
		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Resource not found";
			break;
		}
		case 500: {
			errorMsg = "Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest
				.getAttribute("javax.servlet.error.status_code");
	}
}