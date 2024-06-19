package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController2 {

	@RequestMapping("index.do2") // localhost:8080/sprinMvc/index.do
	public String index(Model model) {
		model.addAttribute("msg", "index.do2 입니다");
		return "index";
	}
	
	@RequestMapping("hello.do2")
	public String hello2(Model model) {
		model.addAttribute("msg", "hello.do2 입니다");
		return "index";
	}
	
	@RequestMapping("hello-raw.do2")
	@ResponseBody
	public String helloraw(HttpServletResponse response) throws IOException {
		return "11111";
	}
}
