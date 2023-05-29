package org.tukorea.starbucks.persistence;

import org.tukorea.starbucks.domain.MenuVO;

import java.util.List;

public interface MenuDAO {

    // 메뉴 리스트
    public List<MenuVO> readList() throws Exception;
    // 메뉴 등록
    public void insert(MenuVO menu) throws Exception;
    // 메뉴 보기
    public MenuVO read(int id) throws Exception;
    // 메뉴 수정
    public void update(MenuVO menu) throws Exception;
    // 메뉴 삭제
    public void delete(int id) throws Exception;
    
    public void deleteToAddTransaction(int id, MenuVO menu) throws Exception;
//    // 리뷰 리스트
//    public List<ReviewVO> readReviewList(int reviewNum) throws Exception;
//    // 리뷰 등록
//    public void reviewInsert(ReviewVO review) throws Exception;
//    // 리뷰 삭제
//    public void reviewDelete(int reviewNum) throws Exception;
}
