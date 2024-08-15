package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;      // 0, 1, 2, ... 키 값 생성해주는 용도

    @Override
    public Member save(Member member) {     // name은 넘어온 상태
        member.setId(++sequence);   // 아이디에 1씩 추가해줌
        store.put(member.getId(), member);

        return member;
        
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));     // Null 값일 수 있기 때문에 Optional.ofNullable()로 감싸준다.

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

    public void clearStore() {
        store.clear();
    }

}
