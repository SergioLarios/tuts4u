package org.tuts4u.view;

import org.tuts4u.model.User;

public class UserHomeView extends AbstractView {

	/* *******************************
	 ********* View fields ***********
	 ****************************** */
	
	private User userProfile;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public User getUserProfile() { return userProfile; }
	public void setUserProfile(User userProfile) { this.userProfile = userProfile; }
	
}
