package repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		//System.out.println("result = " + (result == member)); 의 업그레이드 버전
		Assertions.assertThat(member).isEqualTo(result);
		
	}
}
