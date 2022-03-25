package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	
	//의존관계 주입
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
}
