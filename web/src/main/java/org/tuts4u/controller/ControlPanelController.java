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
public class ControlPanelController {

	/* *******************************************************
	 * *********** Control Panel : "/control-panel" **********
	 * *******************************************************/
	
	@RequestMapping(value = Mappings.CONTROL_PANEL, method = RequestMethod.GET)  
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		return SpringUtils.createMv(Constants.JSP_HOME, "text", new String("TESTTtTing!!!"));
	}
	
}
