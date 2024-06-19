package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("index.do") // localhost:8080/sprinMvc/index.do
	public String index(Model model) {
		model.addAttribute("msg", "index.do 입니다");
		return "index";
	}
	
	@RequestMapping("hello.do")
	public String hello(Model model) {
		model.addAttribute("msg", "hello.do 입니다");
		return "index";
	}
	
	@RequestMapping("hello-raw.do")
	public void helloraw(HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("안녕하세요");
		writer.flush();
	}
	

}
