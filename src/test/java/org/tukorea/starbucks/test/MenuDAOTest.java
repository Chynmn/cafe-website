package org.tukorea.starbucks.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.persistence.MenuDAO;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MenuDAOTest {

	@Autowired
	private MenuDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MenuDAOTest.class);
	
	@Test
	public void testMenuReadByid() throws Exception {
		MenuVO vo;
		vo = dao.read(1);

		logger.info(vo.toString());
	}
	@Test
	public void testMenuReadList() throws Exception {
		List<MenuVO> voList;
		voList = dao.readList();

		for(MenuVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}
