package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	/*
	 * 정적 컨텐츠는 그대로 보여줌. 
	 */
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    
    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
    	model.addAttribute("name", name);
    	return "hello-template";
    }
    
    /*
     * @ResponseBody는 viewResolver 대신에 HttpMessageConverter가 동작한다. 
     * 객체를 보낼 경우 JsonConverter를 사용
     * 문자를 보낼 경우 StringConverter를 사용한다.
     * HTTP의 BODY에 문자 내용을 직접 반환한다.
     * @RequestParam은 파라미터를 받는 방법 중 하나인데, 파라미터 값이 반드시 있어야 한다. 다만 required = false 로 파라미터 값이 필수가 아니도록
     * 설정 할 수도 있다.
     */
    @GetMapping("hello-string")
    @ResponseBody 
    public String helloString(@RequestParam("name") String name) {
    	return "hello " + name; // "hello spring"
    }
    
    /*
     * 최근 프로젝트는 거의 json 방식이다. (key - value)
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloapi(@RequestParam("name") String name) {
    	Hello hello = new Hello();
    	hello.setName(name);
    	return hello;
    }
    
    static class Hello {
    	
    	private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    }
    
}
