package org.tuts4u.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BeanToStringTest {

	private Logger log = Logger.getLogger(BeanToStringTest.class);
	
	@Test
	public void utilTest() {
		
		// TB Padre
		TestBean tb =  new TestBean();
		List<Long> tbl = new ArrayList<Long>();
		tbl.add(0L);tbl.add(1L);tbl.add(2L);tbl.add(3L);
		tb.setList1(tbl);
		
		// TB Hijo 1
		TestBean tbs =  new TestBean();
		List<Long> tbsl = new ArrayList<Long>();
		tbsl.add(0L);tbsl.add(1L);tbsl.add(2L);tbsl.add(3L);
		tb.setList1(tbsl);
		
		// TB Nieto 1
		TestBean tbg =  new TestBean();
		List<Long> tbgl = new ArrayList<Long>();
		tbgl.add(0L);tbgl.add(1L);tbgl.add(2L);tbgl.add(3L);
		tb.setList1(tbgl);
		
		// Asignamiento
		
		tbs.setTb(tbg);
		tb.setTb(tbs);
		
//		tb.toStringLog(log);
//		System.out.println(tb.toString());
		System.out.println(tb.toStringLite());
	}
	
}
