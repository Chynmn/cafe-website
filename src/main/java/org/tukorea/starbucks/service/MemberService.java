package org.tukorea.starbucks.service;

import org.tukorea.starbucks.domain.MemberVO;

public interface MemberService {
    public void register(MemberVO user) throws Exception;
    public MemberVO login(MemberVO user) throws Exception;

    public void deleteMember(String id) throws Exception;
    public void updateMember(MemberVO member) throws Exception;
    public MemberVO readMember(String id) throws Exception;
}
