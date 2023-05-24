package org.tukorea.starbucks.service;

import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.domain.ReviewVO;

import java.util.List;

public interface MenuService {
    public List<MenuVO> menuList() throws Exception;
    public void menuInsert(MenuVO menu) throws Exception;
    public MenuVO menuRead(int num) throws Exception;
    public void menuUpdate(MenuVO menu) throws Exception;
    public void menuDelete(int num) throws Exception;
    public List<ReviewVO> reviewList(int reviewNum) throws Exception;
    public void reviewInsert(ReviewVO review) throws Exception;
    public void reviewDelete(int num) throws Exception;
}
