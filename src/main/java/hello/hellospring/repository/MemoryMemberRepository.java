package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	// HashMap은 Key - Value 형식으로 동작한다.
	private static Map<Long, Member> store = new HashMap<>();
	// Sequence
	private static long sequence = 0L; 
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member); // 값 추가 
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				.filter(member -> member.getName().equals(name))
				.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
	// Store를 싹 비움
	public void clearStore() {
		store.clear();
	}
}
