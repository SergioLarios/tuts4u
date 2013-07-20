package org.tuts4u.helper;

import javax.servlet.http.HttpServletRequest;

import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.form.LoginForm;
import org.tuts4u.util.Validator;
import org.tuts4u.validator.CreateAccountFormValidator;
import org.tuts4u.validator.LoginFormValidator;
import org.tuts4u.view.CreateAccountView;
import org.tuts4u.view.LoginView;

public class CredentialsControllerHelper {

	
	/* *******************************
	 ******** Public Methods *********
	 ****************************** */
	
	/**
	 * ### Create account ###
	 */
	public static CreateAccountView createCreateAccountView(CreateAccountForm form, CreateAccountFormValidator validator,
			HttpServletRequest request) {
		
		CreateAccountView view = new CreateAccountView();
		
		if (Validator.isNull(form)) {
			
			view.setValid(true);
			view.setRegisterForm(new CreateAccountForm());
			
		}
		else {
			
			validator.clean();
			validator.validate(form, request);
			
			view.setValid(validator.isValid());
			view.setErrors(validator.getErrors());
		}
		
		return view;
	}
	
	/**
	 * ### Login ###
	 */
	public static LoginView createLoginView(LoginForm form, LoginFormValidator validator, HttpServletRequest request) {
		LoginView view = new LoginView();
		
		if (Validator.isNull(form)) {
			
			view.setValid(true);
			view.setLoginForm(new LoginForm());
			
		}
		else {
			
			validator.clean();
			validator.validate(form, request);
			
			view.setValid(validator.isValid());
			view.setErrors(validator.getErrors());
		}
		
		return view;
	}
	
}
