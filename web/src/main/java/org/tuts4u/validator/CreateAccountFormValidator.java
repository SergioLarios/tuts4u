package org.tuts4u.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.local.service.UserLocalService;
import org.tuts4u.util.AbstractFormValidator;
import org.tuts4u.util.Validator;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateAccountFormValidator extends AbstractFormValidator{

	@Override
	public void validate(Object form, HttpServletRequest req) {
		CreateAccountForm caForm = (CreateAccountForm)form;
		
		if (Validator.isBlank(caForm.getUserMail())) {
			addError("caf.mail.null");
		}
		
		if (Validator.isBlank(caForm.getPassword()) || Validator.isBlank(caForm.getPasswordRepeat())) {
			addError("caf.pssw.blank");
		}
		
		if (isValid() && !caForm.getPassword().equals(caForm.getPasswordRepeat())) {
			addError("caf.pssw.not-equal");
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
