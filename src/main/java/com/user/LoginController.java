package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    @Autowired
    private UserServiceImpl service; // 서비스를 private으로 선언

    @RequestMapping(value= "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value="/loginOk", method=RequestMethod.POST)
    public String loginCheck(HttpSession session, UserVO vo, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("login") != null) {
            session.removeAttribute("login");
        }
        UserVO loginvo = service.getUser(vo);
        if (loginvo != null) {
            System.out.println("로그인 성공!");
            session.setAttribute("login", loginvo);
            return "redirect:/pet/list"; // 로그인 성공 시 /pet/list로 리다이렉트
        } else {
            System.out.println("로그인 실패!");
            redirectAttributes.addFlashAttribute("loginFailed", true);
            return "redirect:/pet/list"; // 로그인 실패 시 로그인 페이지로 리다이렉트
        }
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login/login";
    }
}
