package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;
import hello.hellospring.domain.Member;

//Repository에서 데이터를 저장함.
public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}
