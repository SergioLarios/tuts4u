package org.tuts4u.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tuts4u.form.LoginForm;
import org.tuts4u.local.service.UserLocalService;
import org.tuts4u.util.AbstractFormValidator;
import org.tuts4u.util.Validator;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginFormValidator extends AbstractFormValidator {

	@Override
	public void validate(Object form, HttpServletRequest req) {
		LoginForm lForm = (LoginForm)form;
		
		if (Validator.isBlank(lForm.getUserMail())) {
			addError("lf.mail.blank");
		}
		
		if (Validator.isBlank(lForm.getPassword())) {
			addError("lf.pssw.blank");
		}
		
		if (isValid() && !userLocalService.checkPssw(lForm.getUserMail(), lForm.getPassword()))  {
			addError("lf.not-match");
		}
		
	}
	
	
	/* *******************************
	 ************* Spring ************
	 ******************************* */
	
	@Autowired
	private UserLocalService userLocalService;

	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public UserLocalService getUserLocalService() { return userLocalService; }
	public void setUserLocalService(UserLocalService userLocalService) { this.userLocalService = userLocalService; }
}
