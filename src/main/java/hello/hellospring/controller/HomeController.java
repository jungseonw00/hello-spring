package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { 
	// 도메인으로 들어오면 처음으로 호출 됨.
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
}
