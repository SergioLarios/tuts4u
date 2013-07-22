package org.tuts4u.session;

import org.tuts4u.util.BeanToString;

public class Page extends BeanToString {

	/* *******************************
	 ********* Bean fields ***********
	 ****************************** */
	
	private int type;
	
	/* *******************************
	 ****** Setters & Getters ********
	 ******************************* */
	
	public int getType() { return type; }
	public void setType(int type) { this.type = type; }
	
	/* *******************************
	 ****** Private constants *******
	 ******************************* */
	
	public static final int OTHER = -1;
	public static final int HOME = 0;
	public static final int EXPLORE = 1;
	public static final int HOW_TO = 2;
	
}
