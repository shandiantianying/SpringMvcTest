package cn.shandian.tianying.intercepotr;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		String fullPath = request.getRequestURI();
		String queryString = request.getQueryString();
		String contextPath = request.getContextPath();
		String controllerPath = fullPath.replace(contextPath, "");
		HttpSession c = request.getSession();
		HttpSession session = request.getSession();
		System.out.println("session:" + session.getAttribute("userName"));
		//// 执行这里表示用户身份需要验证，跳转到登录页面

		if (session == null)
			response.sendRedirect(contextPath);
		return true;

	}

}
