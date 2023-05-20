package org.tukorea.starbucks.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.domain.ReviewVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuDAOImpl implements MenuDAO {
    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.tukorea.starbucks.mapper.MenuMapper";

    @Override
    public List<MenuVO> readMenuList() throws Exception {
        // TODO Auto-generated method stub
        List<MenuVO> menulist = new ArrayList<MenuVO>();
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
        menulist = sqlSession.selectList(namespace+".menu_List", map);

        return menulist;
    }

    @Override
    public void menuInsert(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".menuInsert", menu);
    }

    @Override
    public MenuVO menuRead(Long num) throws Exception {
        // TODO Auto-generated method stub
        MenuVO menuRead = sqlSession.selectOne(namespace+".menuRead", num);

        return menuRead;
    }

    @Override
    public void menuUpdate(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.update(namespace+".menuUpdate", menu);
    }

    @Override
    public void menuDelete(Long num) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.delete(namespace+".menuDelete", num);
    }

    @Override
    public List<ReviewVO> readReviewList(Long num) throws Exception {
        // TODO Auto-generated method stub
        List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
        reviewList = sqlSession.selectList(namespace+".readReviewList", map);

        return reviewList;
    }

    @Override
    public void reviewInsert(ReviewVO review) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.insert(namespace+".reviewInsert", review);
    }

    @Override
    public void reviewDelete(int num) throws Exception {
        // TODO Auto-generated method stub
        sqlSession.delete(namespace+".reviewDelete", num);
    }

}
