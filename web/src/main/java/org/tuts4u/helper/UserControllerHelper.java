package org.tuts4u.helper;

import javax.servlet.http.HttpServletRequest;

import org.tuts4u.model.User;
import org.tuts4u.view.UserHomeView;

public class UserControllerHelper {

	/* *******************************
	 ************ User Home **********
	 ****************************** */
	
	public static UserHomeView createUserHomeView(HttpServletRequest req, User userProfile) {
		
		UserHomeView view = new UserHomeView();
		view.setUserProfile(userProfile);
		
		return view;
	}
	
	/* *******************************
	 ********* User Settings *********
	 ****************************** */
	
	
	
}
