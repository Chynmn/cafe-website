package org.tukorea.starbucks.service;

import org.tukorea.starbucks.domain.MenuVO;

import java.util.List;

public interface MenuService {
    public List<MenuVO> menuList() throws Exception;
    public void menuInsert(MenuVO menu) throws Exception;
    public MenuVO menuRead(int id) throws Exception;
    public void menuUpdate(MenuVO menu) throws Exception;
    public void menuDelete(int id) throws Exception;
    public void deleteAddTransactionMenu(int id, MenuVO menu) throws Exception;
//    public List<ReviewVO> reviewList(int reviewNum) throws Exception;
//    public void reviewInsert(ReviewVO review) throws Exception;
//    public void reviewDelete(int num) throws Exception;
}
