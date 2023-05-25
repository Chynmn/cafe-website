package org.tukorea.starbucks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tukorea.starbucks.domain.MenuVO;
import org.tukorea.starbucks.domain.ReviewVO;
import org.tukorea.starbucks.service.MenuService;
import org.tukorea.utils.UploadFileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping(value = "/starbucks")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

//    @Resource(name ="uploadPath")
//    private String uploadPath;

    @Autowired
    private MenuService menuService;

    // 전체 메뉴 뷸러오기
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menuGet(Model model, HttpServletRequest request) throws Exception {

        List<MenuVO> menu = menuService.menuList();
        HttpSession session = request.getSession();
        model.addAttribute("menu", menu); // 근데 이 모델 어트리뷰트는 무슨 역할인가? JSP에 뿌려줄겨
        model.addAttribute("id", session.getAttribute("id"));
        model.addAttribute("imageFile", session.getAttribute("imageFile"));
        return "starbucks/menu";
    }

    // 메뉴 등록 페이지 이동
    @RequestMapping(value = "/menu_register", method = RequestMethod.GET)
    public String menuInsertGet(Model model, HttpServletRequest request) throws Exception {
       // HttpSession session = request.getSession();

        return "starbucks/menu_register";
    }

    // 메뉴 등록 기능 실행
    @RequestMapping(value = "/menu_insert", method = RequestMethod.POST)
    public String boardWritePost(MenuVO menu, Model model, RedirectAttributes redirect) throws Exception {
        MultipartFile imagefile = menu.getImageFile();
        String imgUploadPath = "uploadPath"+ File.separator + "imgUpload"; // 이미지 업로드 경로
        String fileName = null;

        if(!imagefile.isEmpty()) {
            fileName = UploadFileUtils.fileUpload(imgUploadPath, imagefile.getOriginalFilename(), imagefile.getBytes());
            menu.setImage(fileName);
        }
        else {
            menu.setImage(null);
        }
        menuService.menuInsert(menu);

        Thread.sleep(3000);

//        return "redirect:/menu/menu";
        return "redirect:/menu";
    }

    // 메뉴 삭제 기능 실행
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet(@RequestParam("num") int num, Model model, RedirectAttributes rttr) throws Exception {
        MenuVO menu = menuService.menuRead(num);
        menuService.menuDelete(menu.getId());

        return "redirect:/starbucks/menu"; // <- 경로는 jsp에서 정하면 되는거?  그 mapping 위에 value
    }

    // 메뉴 수정 페이지 이동
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyBoardGet(@RequestParam("num") int num, Model model) throws Exception {
        MenuVO menu = menuService.menuRead(num);
        menuService.menuUpdate(menu);
        model.addAttribute("menu", menu);
        return "starbucks/menu_modify";
    }

    // 메뉴 수정 기능 실행
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyBoardPost(@ModelAttribute("menu") MenuVO menu, RedirectAttributes rttr) throws Exception {
        menuService.menuUpdate(menu);
//        rttr.addAttribute("residence",board.getResidence());
//        rttr.addAttribute("residenceGu",board.getResidenceGu());
        return "redirect:starbucks/menu";
    }

    // 리뷰 등록
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String commentPost(@ModelAttribute("comment") ReviewVO review, RedirectAttributes rttr) throws Exception {
        menuService.reviewInsert(review);

        return "redirect:starbucks/menu";
    }

    // 리뷰 삭제
    @RequestMapping(value = "/commentdelete", method = RequestMethod.GET)
    public String commentDeleteGet(@ModelAttribute("review") ReviewVO review , RedirectAttributes rttr) throws Exception {
        menuService.reviewDelete(review.getReviewNum());

        return "redirect:starbucks/menu";
    }
}
