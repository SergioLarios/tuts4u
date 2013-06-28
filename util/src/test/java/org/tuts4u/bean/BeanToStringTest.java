package org.tuts4u.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BeanToStringTest {

	private Logger log = Logger.getLogger(BeanToStringTest.class);
	
	@Test
	public void utilTest() {
		
		TestBean tb =  new TestBean();
		List<Long> lgs = new ArrayList<Long>();
		lgs.add(0L);lgs.add(1L);lgs.add(2L);lgs.add(3L);
		tb.setList1(lgs);
		System.out.println(tb.toStringLog(log));
		
	}
	
}
