package org.tuts4u.util;

public abstract class AbstractForm {

	/* *******************************
	 ********* Form Fields ***********
	 ****************************** */
	
	private boolean validated;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public boolean isValidated() { return validated; }
	public void setValidated(boolean validated) { this.validated = validated; }
	
}
