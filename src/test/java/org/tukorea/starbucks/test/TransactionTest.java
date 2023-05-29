package org.tukorea.starbucks.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tukorea.starbucks.domain.MemberVO;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.service.MemberService;
import org.tukorea.starbucks.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TransactionTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MenuService menuService;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout = 10)
	public void testDeleteAdd() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("tran"); member.setPasswd("tran"); member.setUser_name("tran"); member.setEmail("tran"); member.setPhone_num("tran"); 
		memberService.register(member);
		
		MenuVO vo = new MenuVO();
		vo.setMenu_name("tran"); vo.setPublisher("tran"); vo.setContent("tran"); vo.setNutrition_info("tran"); vo.setKcal(0); vo.setSaturated_fat(0); vo.setProtein(0); vo.setNatrium(0); vo.setSugars(0); vo.setCaffeine(0); vo.setImage("tran");
		
		menuService.menuInsert(vo);
		
		menuService.deleteAddTransactionMenu(vo.getId(), vo);
		
		
	}
}
