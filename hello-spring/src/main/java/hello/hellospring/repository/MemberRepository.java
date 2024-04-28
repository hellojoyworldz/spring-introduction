package hello.hellospring.repository; //회원 객체를 저장하는 저장소
import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {// 인터페이스 생성
    //회원저장
    Member save(Member member);
    // findById로 찾아옴
    Optional<Member> findById(Long id); //자바8. null 처리 할 때 optional로 감사서 반환
    // findByName으로 찾아옴
    Optional<Member> findByName(String name);
    // 모든 회원 리스트 반환
    List<Member> findAll(); 

}
