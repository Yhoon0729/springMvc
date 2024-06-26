package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import auth.Auth;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Auth auth = (Auth) session.getAttribute("auth");
		
		if(auth == null || !auth.getId().equals("m1")) {
			response.sendRedirect(request.getContextPath()+"/auth/login");
			return false;
		} // end of if()
		
		System.out.println("login: preHandle()");
		return true;
	} // end of preHandle()

}
