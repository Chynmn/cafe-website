package org.tukorea.starbucks.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.starbucks.domain.MemberVO;
import org.tukorea.starbucks.persistence.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService {

    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private MemberDAO memberDAO;

    private static final String namespace = "org.tukorea.starbucks.mapper.UserMapper";

    @Override
    public void register(MemberVO user) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".register", user);
    }

    @Override
    public MemberVO login(MemberVO user) throws Exception {
        // TODO Auto-generated method stub
        return memberDAO.login(user);
    }

    @Override
    public void deleteMember(String id) throws Exception {
        memberDAO.delete(id);
    }

    @Override
    public void updateMember(MemberVO member) throws Exception {
        memberDAO.update(member);
    }

    @Override
    public MemberVO readMember(String id) throws Exception {
        return memberDAO.read(id);
    }
}
