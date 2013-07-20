package org.tuts4u.view;

import org.tuts4u.form.CreateAccountForm;
import org.tuts4u.form.LoginForm;

public class HomeView {

	/* *******************************
	 ********* View fields ***********
	 ****************************** */
	
	private CreateAccountForm registerForm;
	private LoginForm loginForm;
	private boolean home;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public CreateAccountForm getRegisterForm() { return registerForm; }
	public void setRegisterForm(CreateAccountForm registerForm) { this.registerForm = registerForm; }
	
	public LoginForm getLoginForm() { return loginForm; }
	public void setLoginForm(LoginForm loginForm) { this.loginForm = loginForm; }
	
	public boolean isHome() { return home; }
	public void setHome(boolean home) { this.home = home; }
	
}
