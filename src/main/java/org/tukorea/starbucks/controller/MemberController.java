package org.tukorea.starbucks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.starbucks.domain.MemberVO;
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
        logger.info("login GET Method executed.");
        return "member/login";
    }

    @PostMapping(value = "/login")
    public String login(MemberVO user, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
        logger.info("login Post Method executed.");
        HttpSession session = req.getSession();
        MemberVO login = memberService.login(user);
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
    public String getRegister() throws Exception {
        logger.info(" /register URL GET method called. then forward member_register.jsp.");
        return "member/register";
    }

    @PostMapping(value = { "/register" })
    public String createMemberPost(@RequestBody MemberVO vo) throws Exception {
        memberService.register(vo);
    	
        return "redirect:/login";
    }

    // 로그아웃
    @GetMapping(value = "/logout")
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = {"/read"}, method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
        MemberVO member = memberService.readMember(id);
        logger.info(" /read?id=" + id + " URL called. then readMember method executed.");
        model.addAttribute("member", member);

        return "member/member_read";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMemberGet(HttpServletRequest req, Model model) throws Exception {
        HttpSession session = req.getSession();
        String id = (String)session.getAttribute("member");

        MemberVO member = memberService.readMember(id);

        logger.info(" /modify?id=" + id + " URL GET method called. then forward member_modify.jsp.");
        model.addAttribute("member", member);

        return "member/member_modify";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMemberPost(@ModelAttribute("member") MemberVO vo) throws Exception {
        memberService.updateMember(vo);

        logger.info(vo.toString());
        logger.info("/modify?id=" + vo.getId() + " URL POST method called. then modifyMemberPost executed.");

        return "redirect:/mission/list";
    }

}
