package org.tuts4u.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tuts4u.constant.Constants;
import org.tuts4u.constant.Mappings;
import org.tuts4u.view.ExploreView;
import org.tuts4u.web.SpringUtils;

@Controller
public class ExplreController {

	/* *******************************************************
	 * ***************** Explore : /explore ****************** 
	 * *******************************************************/

	@RequestMapping(value = Mappings.EXPLORE, method = RequestMethod.GET)  
	public ModelAndView explore(HttpServletRequest request, HttpServletResponse response) {
	
		ExploreView view = new ExploreView();
		view.setExplore(true);
		
		return SpringUtils.createMv(Constants.JSP_EXPLORE, Constants.VIEW, view);
	}
	
}
