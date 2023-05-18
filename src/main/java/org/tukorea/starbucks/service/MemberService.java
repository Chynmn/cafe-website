package org.tukorea.starbucks.service;

import org.tukorea.starbucks.domain.UserVO;

public interface MemberService {
    public void register(UserVO user) throws Exception;
    public UserVO login(UserVO user) throws Exception;
}
