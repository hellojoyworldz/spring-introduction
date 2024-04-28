package hello.hellospring.repository; // 구현체

import hello.hellospring.domain.Member;

import java.util.*;

// class를 만들고 MemberRepository를 inplements 해서
// option + enter 해서 가져오기
public class MemoryMemberRepository implements MemberRepository {

    // Save를 할 때 어딘가 저장해야함
    // ctrl + 스페이스 or Option + enter로 import
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // key값을 생성해주는 것


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // return store.get(id) -> null 처리 해줌
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 루프로 돌리면서 lambda가 사용됨
        // member.getName()이 파라메타로 넘어온 name이랑 같은지 확인하여 찾으면 반환
        // findAny() 결과가 optional로 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
