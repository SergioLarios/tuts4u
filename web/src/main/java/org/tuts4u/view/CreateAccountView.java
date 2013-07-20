package org.tuts4u.view;

import java.util.List;

import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.util.BeanToString;

public class CreateAccountView extends BeanToString {

	/* *******************************
	 ********* View fields ***********
	 ****************************** */
	
	private CreateAccountForm registerForm;
	private List<String> errors;
	private boolean valid;
	private boolean home;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public CreateAccountForm getRegisterForm() { return registerForm; }
	public void setRegisterForm(CreateAccountForm form) { this.registerForm = form; }
	
	public List<String> getErrors() { return errors; }
	public void setErrors(List<String> errors) { this.errors = errors; }
	
	public boolean isValid() { return valid; }
	public void setValid(boolean valid) { this.valid = valid; }
	
	public boolean isHome() { return home; }
	public void setHome(boolean home) { this.home = home; }
	
}
