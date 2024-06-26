package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import member.MemberInfo;
import service.MemberService;

@Controller
public class JsonController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/json/list")
	@ResponseBody
	public List<MemberInfo> jsonList() {
		
		return memberService.getMembers();
	}
	
	@RequestMapping("/json/map")
	@ResponseBody
	public Map<String, MemberInfo> jsonMap() {
		return memberService.memberMap;
	}
}
