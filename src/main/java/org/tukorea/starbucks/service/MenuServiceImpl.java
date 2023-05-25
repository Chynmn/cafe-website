package org.tukorea.starbucks.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.persistence.MenuDAO;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private MenuDAO menuDAO;

//    ReviewVO review = new ReviewVO();


    private static final String namespace = "org.tukorea.starbucks.mapper.MenuMapper";

    @Override
    public List<MenuVO> menuList() throws Exception {
        // TODO Auto-generated method stub

        return menuDAO.readList();
    }

    @Override
    public void menuInsert(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub

        sqlSession.insert(namespace+".menuInsert", menu);
    }

    @Override
    public MenuVO menuRead(int id) throws Exception {
        // TODO Auto-generated method stub

        return menuDAO.read(id);
    }

    @Override
    public void menuUpdate(MenuVO menu) throws Exception {
        // TODO Auto-generated method stub

        menuDAO.update(menu);
    }

    @Override
    public void menuDelete(int id) throws Exception {
        // TODO Auto-generated method stub

        menuDAO.delete(id);
    }

    @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED)
    public void deleteAddTransactionMenu(int id, MenuVO menu) throws Exception {
        menuDAO.deleteToAddTransaction(id, menu);
    }

//    @Override
//    public List<ReviewVO> reviewList(int reviewNum) throws Exception {
//        // TODO Auto-generated method stub
//        return menuDAO.readReviewList(reviewNum);
//    }
//
//    @Override
//    public void reviewInsert(ReviewVO review) throws Exception {
//        // TODO Auto-generated method stub
//        menuDAO.reviewInsert(review);
//    }
//
//    @Override
//    public void reviewDelete(int reviewNum) throws Exception {
//        // TODO Auto-generated method stub
//
//        menuDAO.reviewDelete(reviewNum);

}
