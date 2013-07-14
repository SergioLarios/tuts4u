package org.tuts4u.util;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.tuts4u.web.FormUtils;

public class FormUtilsTest {

	@Test
	public void main() {
		
		// First we create a mocked request
		MockHttpServletRequest mockReq = new MockHttpServletRequest();
		
		// Then we emulate a request with all the parameters
		mockReq.setParameter(TestForm.STRING, "test string");
		
		mockReq.setParameter(TestForm.BOOLEAN_P, "true");
		mockReq.setParameter(TestForm.BOOLEAN_O, "true");
		
		mockReq.setParameter(TestForm.INT_P, "11");
		mockReq.setParameter(TestForm.INT_O, "12");
		
		mockReq.setParameter(TestForm.LONG_P, "21");
		mockReq.setParameter(TestForm.LONG_O, "22");
		
		mockReq.setParameter(TestForm.DOUBLE_P, "3.1");
		mockReq.setParameter(TestForm.DOUBLE_O, "3,2");
		
		mockReq.setParameter(TestForm.FLOAT_P, "4.1");
		mockReq.setParameter(TestForm.FLOAT_O, "4,2");
		
		mockReq.setParameter(TestForm.CHAR_P, "a");
		mockReq.setParameter(TestForm.CHAR_O, "b");
		
		String[] stringL = {"String1", "String1"};
		mockReq.setParameter(TestForm.LIST_STRING, stringL);
		
		String[] booleanL = {"true", "false"};
		mockReq.setParameter(TestForm.LIST_BOOLEAN, booleanL);
		
		String[] intL = {"111", "112"};
		mockReq.setParameter(TestForm.LIST_INT, intL);
		
		String[] longL = {"211", "212"};
		mockReq.setParameter(TestForm.LIST_LONG, longL);
		
		String[] doubleL = {"31.1", "31,2"};
		mockReq.setParameter(TestForm.LIST_DOUBLE, doubleL);
		
		String[] floatL = {"41.1", "41,2"};
		mockReq.setParameter(TestForm.LIST_FLOAT, floatL);
		
		String[] charL = {"x", "y"};
		mockReq.setParameter(TestForm.LIST_CHAR, charL);
		
		mockReq.setParameter(TestForm.DATE_YEAR, "1991");
		mockReq.setParameter(TestForm.DATE_MONTH, "08");
		mockReq.setParameter(TestForm.DATE_DAY, "21");
		
		mockReq.setParameter(TestForm.NO_PARAM, "This field is not annotated then it won't "
				+ " be filled even if the parametter is the same than the field");
		
		// Then we run the "magic"
		TestForm tb = FormUtils.fillForm(mockReq, TestForm.class);
		
		// finally we check the output
		System.out.println(tb.toString());
	}
	
}
