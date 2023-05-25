package org.tukorea.starbucks.persistence;


import org.tukorea.starbucks.domain.MemberVO;

public interface MemberDAO {

    // 회원가입
    public void register(MemberVO user) throws Exception;

    // 로그인
    public MemberVO login(MemberVO user) throws Exception;

    // 탈퇴
    public void delete(String id) throws Exception;

    // 회원정보 수정
    public void update(MemberVO member) throws Exception;

    public MemberVO read(String id) throws Exception;

}
