package org.tuts4u.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.tuts4u.constant.Constants;
import org.tuts4u.constant.UserConstants;
import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.form.LoginForm;
import org.tuts4u.model.User;
import org.tuts4u.view.HomeView;

public class HomeControllerHelper {

	/* *******************************
	 ************** Home *************
	 ****************************** */
	
	public static HomeView createHomeView(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute(Constants.SESSION_USER);
		
		HomeView view = new HomeView();
		view.setLoginForm(new LoginForm());
		view.setRegisterForm(new CreateAccountForm());
		view.setHome(true);
		if (user.getType() == UserConstants.GUEST) {
			view.setLoggedIn(false);
		}
		else {
			view.setLoggedIn(true);
		}
		
		return view;
	}
	
}
