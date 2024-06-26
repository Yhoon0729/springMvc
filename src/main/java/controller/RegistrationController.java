package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import member.MemberRegistRequest;
import member.MemberRegistValidator;

@Controller
@RequestMapping("/member/regist")
public class RegistrationController {

	private static final String MEMBER_REGISTRATION_FORM 
		= "member/registrationForm";
	
	@GetMapping
	public String form(@ModelAttribute("memberInfo") 
						MemberRegistRequest memRegReq) {
		
		return MEMBER_REGISTRATION_FORM;
	}
	
	@PostMapping
	public String regist(
			@ModelAttribute("memberInfo") MemberRegistRequest memRegReq,
			BindingResult bindingResult) {
		System.out.println(bindingResult);
		
		new MemberRegistValidator().validate(memRegReq, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return MEMBER_REGISTRATION_FORM;
		}
		return "member/registered";
	}
}
