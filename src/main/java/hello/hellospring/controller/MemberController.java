package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

	private MemberService memberService;
	
	//의존관계 주입
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}
	
	// 데이터를 등록할 때 보통 post를 사용한다.
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		System.out.println("create Method() parameter form --> " + form.getName());
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		return "redirect:/";
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMember();
		model.addAttribute("members", members);
		for(int i=0; i<members.size(); i++) {
			System.out.println("members의 값은 --> " + members.get(i).getName());			
		}
		return "members/memberList";
	}
}