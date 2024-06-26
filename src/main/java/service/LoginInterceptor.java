package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import auth.Auth;

@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Auth auth = (Auth) session.getAttribute("auth");
		
		if(auth != null) {
			return true;
		} else {
			response.sendRedirect(request.getContextPath()+"/auth/login");
		} // end of if(auth != null)
		
		System.out.println("login: preHandle()");
		return true;
	} // end of preHandle()
}
