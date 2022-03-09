package repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

class MemoryMemberRepositoryTest {

	MemoryMemberRepository repository = new MemoryMemberRepository();

	// Test가 끝나고 항상 실행하는 Method
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
		
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		
		// System.out.println("result = " + (result == member)); 의 업그레이드 버전
		assertThat(member).isEqualTo(result);
	}
		
	@Test
	public void findByName() {
		// member1 객체의 name을 spring1으로 설정 
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		// member2 객체의 name을 spring2으로 설정 
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring1").get();
		
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		assertThat(result.size()).isEqualTo(2);			
	}
	
}
