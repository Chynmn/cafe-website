package org.tukorea.starbucks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.starbucks.domain.UserVO;
import org.tukorea.starbucks.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired(required = true)
    private MemberService memberService;

    // 로그인
    @GetMapping(value = "/login")
    public String getlogin() throws Exception{
        return "/member/login";
    }

    @PostMapping(value = "/login")
    public String login(UserVO user, HttpServletRequest req, RedirectAttributes rttr) throws Exception {

        HttpSession session = req.getSession();
        UserVO login = memberService.login(user);
        if (login == null) {
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", false);
        } else {
            session.setAttribute("id", login);
        }
        return null;
    }

    // 회원가입
    @GetMapping(value = { "/register" })
    public void getRegister() throws Exception {
        logger.info(" /register URL GET method called. then forward member_register.jsp.");

    }

    @PostMapping(value = { "/register" })
    public String createMemberPost(@RequestBody UserVO vo) throws Exception {
        memberService.register(vo);
    	
        return "redirect:/";
    }

    // 로그아웃
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }



}
