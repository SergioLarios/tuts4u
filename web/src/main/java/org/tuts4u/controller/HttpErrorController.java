package org.tuts4u.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tuts4u.constant.Constants;
import org.tuts4u.constant.Mappings;
import org.tuts4u.web.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HttpErrorController {

	/* *******************************************************
	 * **************** Error 404 : Not found **************** 
	 * *******************************************************/
	@RequestMapping(value = Mappings.HTTP_404, method = RequestMethod.GET)  
	public ModelAndView handle404(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return SpringUtils.createMv(Constants.JSP_404, "text", new String("TESTTtTing!!!"));
	}
	
	/* *******************************************************
	 * ************** Error 403 : Forbidden path ************* 
	 * *******************************************************/
	@RequestMapping(value = Mappings.HTTP_403, method = RequestMethod.GET)  
	public ModelAndView handle403(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return SpringUtils.createMv(Constants.JSP_403, "text", new String("TESTTtTing!!!"));
	}
	
}
