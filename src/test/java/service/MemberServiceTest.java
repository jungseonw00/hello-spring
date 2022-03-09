package service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

class MemberServiceTest {

	MemberService memberService = new MemberService();
	
	//Test는 메소드 이름을 직관적으로 한글로 적어도 된다.
	@Test
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("hello");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
}
