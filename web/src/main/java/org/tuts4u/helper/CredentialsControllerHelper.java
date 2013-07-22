package org.tuts4u.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.tuts4u.constant.Constants;
import org.tuts4u.constant.UserConstants;
import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.form.LoginForm;
import org.tuts4u.local.service.UserLocalService;
import org.tuts4u.model.User;
import org.tuts4u.util.Validator;
import org.tuts4u.validator.CreateAccountFormValidator;
import org.tuts4u.validator.LoginFormValidator;
import org.tuts4u.view.CreateAccountView;
import org.tuts4u.view.LoginView;
import org.tuts4u.web.UrlUtils;

public class CredentialsControllerHelper {

	
	/* *******************************
	 ******** Public Methods *********
	 ****************************** */
	
	/**
	 * ### Create account ###
	 */
	public static CreateAccountView createCreateAccountView(CreateAccountForm form, CreateAccountFormValidator validator,
			HttpServletRequest request, UserLocalService userLocalService) {
		
		CreateAccountView view = new CreateAccountView();
		
		if (Validator.isNull(form)) {
			
			view.setValid(true);
			view.setRegisterForm(new CreateAccountForm());
			
		}
		else {
			
			validator.clean();
			validator.validate(form, request);
			
			if (validator.isValid()) {
				
				String userNameS = UrlUtils.simplifyStringToUrl(form.getUserName());
				
				User user = new User();
				user.setType(UserConstants.NORMAL);
				user.setUserName(form.getUserName());
				user.setUserNameSimple(userNameS);
				user.setMail(form.getUserMail());
				
				userLocalService.updatePassword(user, form.getPassword());
				
				HttpSession session = request.getSession();
				User sUser = userLocalService.loginUser(user.getMail());
				session.setAttribute(Constants.SESSION_USER, sUser);
				
				view.setLoggedIn(true);
				
			}
			else {
				view.setValid(validator.isValid());
				view.setErrors(validator.getErrors());
			}
			
		}
		
		return view;
	}
	
	/**
	 * ### Login ###
	 */
	public static LoginView createLoginView(LoginForm form, LoginFormValidator validator, 
			HttpServletRequest request, UserLocalService userLocalService) {
		
		LoginView view = new LoginView();
		
		if (Validator.isNull(form)) {
			
			view.setValid(true);
			view.setLoginForm(new LoginForm());
			
		}
		else {
			
			validator.clean();
			validator.validate(form, request);
			
			if (validator.isValid()) {
				
				HttpSession session = request.getSession();
				User sUser = userLocalService.loginUser(form.getUserMail());
				session.setAttribute(Constants.SESSION_USER, sUser);
				
				view.setLoggedIn(true);
				
			}
			else {
				view.setValid(validator.isValid());
				view.setErrors(validator.getErrors());
			}
			
		}
		
		return view;
	}
	
}
