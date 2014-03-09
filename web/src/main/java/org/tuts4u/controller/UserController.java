package org.tuts4u.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tuts4u.constant.Constants;
import org.tuts4u.constant.Mappings;
import org.tuts4u.helper.UserControllerHelper;
import org.tuts4u.local.service.UserLocalService;
import org.tuts4u.model.User;
import org.tuts4u.util.Validator;
import org.tuts4u.view.UserHomeView;
import org.tuts4u.web.SpringUtils;

@Controller
public class UserController {

	/* *******************************************************
	 * ************* User Home : /user/{userName} ************ 
	 * *******************************************************/
	
	@RequestMapping(value = Mappings.USER_HOME, method = RequestMethod.GET) 
	public ModelAndView userHome(@PathVariable String userName, 
			HttpServletRequest request, HttpServletResponse response) {
		
		User userProfile = userLocalService.findByUserNameSimple(userName);
		if (Validator.isNull(userProfile)) {
			SpringUtils.sendError(response);
		}
		
		UserHomeView view = UserControllerHelper.createUserHomeView(request, userProfile);
		
		return SpringUtils.createMv(Constants.JSP_USER_HOME, Constants.VIEW, view);
	}
	
	/* *******************************************************
	 * ****** User settings : /user/{userName}/settings ****** 
	 * *******************************************************/
	
	@RequestMapping(value = Mappings.USER_SETTINGS, method = RequestMethod.GET)
	public ModelAndView userSettings(@PathVariable String userName, 
			HttpServletRequest request, HttpServletResponse response) {
		
		User userProfile = userLocalService.findByUserNameSimple(userName);
		UserHomeView view = UserControllerHelper.createUserHomeView(request, userProfile);
		
		return SpringUtils.createMv(Constants.JSP_USER_HOME, Constants.VIEW, view);
	}
	
	/* *******************************
	 ******* Injected objects ********
	 ****************************** */
	
	@Autowired
	private UserLocalService userLocalService;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */

	public UserLocalService getUserLocalService() { return userLocalService; }
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}
	
}
