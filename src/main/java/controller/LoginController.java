package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import auth.Auth;
import auth.AuthenticationException;
import auth.LoginCommand;
import service.Authenticator;

@Controller
@RequestMapping("/auth/login")
public class LoginController {
	private static final String LOGIN_FORM = "auth/loginForm";
	
	@Autowired
	private Authenticator authenticator;

	@GetMapping
	public String loginForm(LoginCommand loginCommand, Model m, String msg) {
		return LOGIN_FORM;
	}
	
	@PostMapping
	public String login(LoginCommand loginCommand, HttpServletRequest request) {
		String msg = request.getParameter("msg");
		String url = request.getParameter("url");
		
		if(url != null) {
			url = url.substring(request.getContextPath().length());
		} else {
			url = "/index";
		}
		
		try {
			Auth auth = authenticator.authenticate(loginCommand.getEmail(),
					loginCommand.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("auth", auth);
			System.out.println(auth);
			return "redirect:"+url;
		} catch(AuthenticationException e) {
			if(msg == null) {
				return LOGIN_FORM;
			} else {
				return "redirect:/auth/login";
			}
		} // end of tryCatch
	} // end of login()
	
}
