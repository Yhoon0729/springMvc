package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberRegistRequest;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	private static final String MEMBER_REGISTRATION_FORM = "member/registrationForm";
	
	@GetMapping
	public String form(@ModelAttribute("memberInfo") 
						MemberRegistRequest memRegReq) {
		
		return MEMBER_REGISTRATION_FORM;
	}
}
