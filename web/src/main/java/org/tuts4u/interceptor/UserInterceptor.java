package org.tuts4u.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.tuts4u.constant.Constants;
import org.tuts4u.constant.UserConstants;
import org.tuts4u.model.User;
import org.tuts4u.util.Validator;

public class UserInterceptor implements HandlerInterceptor {

	/* *******************************************************
	 * ********************** Pre Handle *********************
	 * *******************************************************/
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.SESSION_USER);
		
		if (Validator.isNull(user)) {
			user = new User();
			user.setType(UserConstants.GUEST);
			session.setAttribute(Constants.SESSION_USER, user);
		}
		
		return true;
	}
	

	/* *******************************************************
	 * ********************* Post Handle *********************
	 * *******************************************************/
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	/* *******************************************************
	 * ******************* After Completion ******************
	 * *******************************************************/
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
