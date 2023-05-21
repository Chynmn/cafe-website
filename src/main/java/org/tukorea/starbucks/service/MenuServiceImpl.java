package org.tukorea.starbucks.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.domain.ReviewVO;
import org.tukorea.starbucks.persistence.MenuDAO;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private MenuDAO menuDAO;

    ReviewVO review = new ReviewVO();


    private static final String namespace = "org.tukorea.starbucks.mapper.MenuMapper";

    @Override
    public List<MenuVO> menuList() throws Exception {
        // TODO Auto-generated method stub

        return menuDAO.readMenuList();
    }

    @Override
    public void menuInsert(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub

        sqlSession.insert(namespace+".menuInsert", menu);
    }

    @Override
    public MenuVO menuRead(int num) throws Exception {
        // TODO Auto-generated method stub

        return menuDAO.menuRead(num);
    }

    @Override
    public void menuUpdate(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub

        menuDAO.menuUpdate(menu);
    }

    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
    @Override
    public void menuDelete(int num) throws Exception {
        // TODO Auto-generated method stub

        menuDAO.reviewDelete(num);
        menuDAO.menuDelete(num);
    }

    @Override
    public List<ReviewVO> reviewList(int reviewNum) throws Exception {
        // TODO Auto-generated method stub
        return menuDAO.readReviewList(reviewNum);
    }

    @Override
    public void reviewInsert(ReviewVO review) throws Exception {
        // TODO Auto-generated method stub
        menuDAO.reviewInsert(review);
    }

    @Override
    public void reviewDelete(int reviewNum) throws Exception {
        // TODO Auto-generated method stub

        menuDAO.reviewDelete(reviewNum);
    }
}
