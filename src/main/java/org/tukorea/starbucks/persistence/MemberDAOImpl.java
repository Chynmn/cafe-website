package org.tukorea.starbucks.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.starbucks.domain.MemberVO;

@Component
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.starbucks.mapper.UserMapper";

    @Override
    public void register(MemberVO user) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".register", user);

    }

    @Override
    public MemberVO login(MemberVO user) throws Exception {
        // TODO Auto-generated method stub
        return sqlSession.selectOne(namespace+".login",user);
    }

    @Override
    public void delete(String id) throws Exception {
        sqlSession.delete(namespace + ".delete", id);
    }

    @Override
    public void update(MemberVO member) throws Exception {
        sqlSession.update(namespace + ".update", member);
    }

    @Override
    public MemberVO read(String id) throws Exception {
        return sqlSession.selectOne(namespace + ".selectByid", id);
    }
}
