package org.tukorea.starbucks.persistence;

import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.domain.ReviewVO;

import java.util.List;

public interface MenuDAO {

    // 메뉴 리스트
    public List<MenuVO> readMenuList() throws Exception;
    // 메뉴 등록
    public void menuInsert(MenuVO menu) throws Exception;
    // 메뉴 보기
    public MenuVO menuRead(int num) throws Exception;
    // 메뉴 수정
    public void menuUpdate(MenuVO menu) throws Exception;
    // 메뉴 삭제
    public void menuDelete(int num) throws Exception;
    // 리뷰 리스트
    public List<ReviewVO> readReviewList(int reviewNum) throws Exception;
    // 리뷰 등록
    public void reviewInsert(ReviewVO review) throws Exception;
    // 리뷰 삭제
    public void reviewDelete(int reviewNum) throws Exception;
}
