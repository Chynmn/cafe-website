package org.tukorea.starbucks.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.starbucks.domain.MenuVO;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDAOImpl implements MenuDAO {
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.starbucks.mapper.MenuMapper";

    @Override
    public List<MenuVO> readList() throws Exception {
        // TODO Auto-generated method stub
        List<MenuVO> menulist = new ArrayList<MenuVO>();
        menulist = sqlSession.selectList(namespace+".selectAll");

        return menulist;
    }

    @Override
    public void insert(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".insert", menu);
    }

    @Override
    public MenuVO read(int id) throws Exception {
        // TODO Auto-generated method stub
        MenuVO menuRead = sqlSession.selectOne(namespace+".read", id);

        return menuRead;
    }

    @Override
    public void update(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.update(namespace+".update", menu);
    }

    @Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED, timeout = 10)
    public void delete(int id) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.delete(namespace+".delete", id);
    }

    @Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.READ_COMMITTED, timeout = 10)
    public void deleteToAddTransaction(int id, MenuVO menu) throws Exception {
        sqlSession.delete(namespace + ".delete", id);
        sqlSession.update(namespace + ".insert", menu);
    }

//    @Override
//    public List<ReviewVO> readReviewList(int reviewNum) throws Exception {
//        // TODO Auto-generated method stub
//        List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
//        Map<String, Object> map = new HashMap<>();
////        map.put("id", id);
//        reviewList = sqlSession.selectList(namespace+".readReviewList", map);
//
//        return reviewList;
//    }
//
//    @Override
//    public void reviewInsert(ReviewVO review) throws Exception {
//        // TODO Auto-generated method stub
//        sqlSession.insert(namespace+".reviewInsert", review);
//    }
//
//    @Override
//    public void reviewDelete(int reviewNum) throws Exception {
//        // TODO Auto-generated method stub
//        sqlSession.delete(namespace+".reviewDelete", reviewNum);
//    }

}
