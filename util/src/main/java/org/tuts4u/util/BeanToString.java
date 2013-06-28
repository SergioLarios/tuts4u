package org.tuts4u.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

import org.apache.log4j.Logger;

import static org.tuts4u.constant.StringPool.*;


@SuppressWarnings(value = {"rawtypes", "unchecked"})
public abstract class BeanToString {

	/* *******************************
	 ****** Overridden toString ******
	 ******************************* */
	
	@Override
	public String toString() {
		return toStringPrivate(getClass(), this, null, 0);
	}
	
	public String toStringLog(Logger log) {
		System.out.println(this.getClass());
		return toStringPrivate(getClass(), this, log, 0);
	}
	
	/* *******************************
	 ******** Private methods ********
	 ******************************* */
	
	private static String toStringPrivate(Class clazz, Object obj, Logger log, int tabNum) {
		
		Field[] fields = clazz.getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		String tabs = BLANK;
		for (int i = 0; i < tabNum; i++) {
			tabs = tabs + TAB;
		}
		Object[] logObjs = {sb, log, tabs};
		
		// Bean header
		append(logObjs, SEPARATOR + clazz.getSimpleName() + SEPARATOR + NEW_LINE);
		
		for (Field field : fields) {

			logObjs = recursiveString(clazz, obj, field, logObjs);
			
		}
		
		return sb.toString();
		
	}
	
	private static Object[] recursiveString(Class clazz, Object obj, Field field, Object[] logObjs) {
		
		if (isCollection(field)) {
			
			Collection col = getCollection(clazz, field, logObjs);
			
			for (Object object : col) {
				append(logObjs, "" + object);
			}
			
		}
		else {
			String fieldName = upperCaseFirstLetter(field.getName());
			String fieldValue = getFieldValue(clazz, field, obj);
			
			append(logObjs, fieldName + SPACE + COLON + SPACE + fieldValue + NEW_LINE);
		}
		
		return logObjs;
	}
	
	/**
	 * Uppercases first letter 
	 * @param s
	 * @return
	 */
	private static String upperCaseFirstLetter(String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1);
	}
	
	/**
	 * Checks if the class is Boolean or boolean
	 * @param clazz
	 * @return
	 */
	private static boolean isBoolean(Class clazz) {
		return (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) ? true : false;
	}
	
	/**
	 * Checks the method name exists in the given class
	 * @param methodName
	 * @param clazz
	 * @return
	 */
	private static Method checkMethod(String methodName, Class clazz) {
		try {
			return clazz.getMethod(methodName);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Gets the field value given its class, the desired field and an instance
	 * @param clazz
	 * @param field
	 * @param obj
	 * @return
	 */
	private static String getFieldValue(Class clazz, Field field, Object obj) {
		String fieldValue = null;
		
		try {
			
			String fieldName = upperCaseFirstLetter(field.getName());
			
			if (isBoolean(field.getType())) {
				Method fieldGetter = checkMethod(IS + fieldName, clazz); 
				if (fieldGetter == null) {
					fieldGetter = checkMethod(GET + fieldName, clazz);
				}
				Object returnObj = fieldGetter.invoke(obj);
				return (returnObj == null) ? NULL : returnObj.toString();
			}
			else {
				Method fieldGetter = clazz.getDeclaredMethod(GET + fieldName);
				Object returnObj = fieldGetter.invoke(obj);
				return (returnObj == null) ? NULL : returnObj.toString();
			}
		} catch (Exception e) {
			fieldValue = NO_GETTER;
		}
		
		return fieldValue;
	}
	
	/**
	 * Checks if the given object is iterable
	 * @param field
	 * @return
	 */
	private static boolean isCollection(Field field) {
		Class clazz = field.getType();
		return Collection.class.isAssignableFrom(clazz);
	}
	
	/**
	 * Gets the collection given the field
	 * @param clazz
	 * @param field
	 * @param obj
	 * @return
	 */
	private static Collection getCollection(Class clazz, Field field, Object obj) {
		Collection col = null;
		
		try {
			
			String fieldName = upperCaseFirstLetter(field.getName());
			
			Method fieldGetter = clazz.getDeclaredMethod(GET + fieldName);
			
			Object returnObj = fieldGetter.invoke(obj);
			return (Collection)returnObj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return col;
	}
	
	/**
	 * Appends the string to the sb and will try to log it at info level.
	 * @param logObjs
	 * @param msg
	 * @return
	 */
	private static StringBuilder append(Object[] logObjs, String msg) {
		
		StringBuilder sb = (StringBuilder) logObjs[0];
		Logger log = (Logger) logObjs[1];
		String tabs = (String) logObjs[2];
		
		sb.append(tabs + msg);
		if (log !=  null) {
			log.info(tabs + msg);
		}
		return sb;
	}
	
	/* *******************************
	 ******* Private Constants *******
	 ******************************* */
	
	private static final String GET = "get";
	private static final String IS = "is";
	private static final String NULL = "null";
	private static final String NO_GETTER = "No getter defined";
	private static final String SEPARATOR = "_________";
	
}
