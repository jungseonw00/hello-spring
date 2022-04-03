package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

// 아래 어노테이션을 넣으면 스프링 컨테이너와 테스트를 함께 실행한다.
@SpringBootTest
// 아래 어노테이션을 넣으면 insert한 Query를 테스트 후 rollback 해줌.
@Transactional
class MemberServiceIntergrationTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRepository memberRepository;
	
	// Test는 메소드 이름을 직관적으로 한글로 적어도 된다.
	@Test
	void 회원가입() throws Exception {
		// Given
		Member member = new Member();
		member.setName("spring");

		// When
		Long saveId = memberService.join(member);

		// Then
		Member findMember = memberService.findOne(saveId).get();
		assertEquals(member.getName(), findMember.getName());
	}

	@Test
	public void 중복_회원_예외() {
		// Given
		Member member1 = new Member();
		member1.setName("spring");

		Member member2 = new Member();
		member2.setName("spring");

		// When
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
				() -> memberService.join(member2));	// 예외가 발생해야 한다.
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
}
