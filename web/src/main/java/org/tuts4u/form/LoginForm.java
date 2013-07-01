package org.tuts4u.form;

import org.tuts4u.util.BeanToString;

public class LoginForm extends BeanToString{

	/* *******************************
	 ********* Form Fields ***********
	 ****************************** */
	
	private String userMail;
	private String password;
	
	/* *******************************
	 ********* Form Names ************
	 ****************************** */
	
	public static final String USER_MAIL = "login.usermail";
	public static final String USER_PASSWORD = "login.password";
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public String getUserMail() { return userMail; }
	public void setUserMail(String userMail) { this.userMail = userMail; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
}
