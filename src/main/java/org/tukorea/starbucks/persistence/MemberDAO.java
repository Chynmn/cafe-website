package org.tukorea.starbucks.persistence;


import org.tukorea.starbucks.domain.UserVO;

import java.util.List;

public interface MemberDAO {

    // 회원가입
    public void register(UserVO user) throws Exception;

    // 로그인
    public UserVO login(UserVO user) throws Exception;

}
