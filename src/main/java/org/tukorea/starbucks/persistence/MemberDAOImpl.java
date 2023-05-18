package org.tukorea.starbucks.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.starbucks.domain.UserVO;

@Component
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.starbucks.mapper.UserMapper";

    @Override
    public void register(UserVO user) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".register", user);

    }

    @Override
    public UserVO login(UserVO user) throws Exception {
        // TODO Auto-generated method stub
        return sqlSession.selectOne(namespace+".login",user);
    }
}
