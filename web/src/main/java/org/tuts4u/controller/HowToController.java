package org.tuts4u.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tuts4u.constant.Constants;
import org.tuts4u.constant.Mappings;
import org.tuts4u.view.HowToView;
import org.tuts4u.web.SpringUtils;

@Controller
public class HowToController {

	/* *******************************************************
	 * ****************** How to : /how-to ******************* 
	 * *******************************************************/

	@RequestMapping(value = Mappings.HOW_TO, method = RequestMethod.GET)  
	public ModelAndView explore(HttpServletRequest request, HttpServletResponse response) {
		
		HowToView view = new HowToView();
		
		return SpringUtils.createMv(Constants.JSP_HOW_TO, Constants.VIEW, view);
	}
}