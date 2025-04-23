package com.sjj.controller;

import com.sjj.entity.Stu;
import com.sjj.entity.User;
import com.sjj.service.StuService;
import com.sjj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StuService stuService;
    // ====================== 登录功能 ======================
    @GetMapping("/login")
    public String loginPage(Model model) {
        if (model.containsAttribute("error")) {
            model.addAttribute("error", model.getAttribute("error"));
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", username);
            return "redirect:/emp/student";
        } else {
            redirectAttributes.addFlashAttribute("error", "用户名或密码错误");
            return "redirect:/login";
        }
    }

    // ====================== 注册功能 ======================
    @GetMapping("/regist")
    public String registPage(Model model) {
        if (model.containsAttribute("error")) {
            model.addAttribute("error", model.getAttribute("error"));
        }
        return "regist";
    }

    @PostMapping("/regist")
    public String regist(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.save(user);
            redirectAttributes.addFlashAttribute("success", "注册成功");
            return "redirect:/login";
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("error", "注册失败，用户名已存在");
            return "redirect:/regist";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "注册失败，请重试");
            return "redirect:/regist";
        }
    }

}
