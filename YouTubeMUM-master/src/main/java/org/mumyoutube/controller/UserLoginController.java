package org.mumyoutube.controller;

import org.mumyoutube.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserLoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String handleRequest(HttpServletRequest request, Model model) {


        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        model.addAttribute("uri", request.getRequestURI())
                .addAttribute("user", auth.getName())
                .addAttribute("roles", auth.getAuthorities());
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model,  @ModelAttribute User loginBean, BindingResult result) {
        if (loginBean != null && loginBean.getUserName() != null
                & loginBean.getPassword() != null) {
            if (loginBean.getUserName().equals("chandra")
                    && loginBean.getPassword().equals("chandra123")) {
                model.addAttribute("msg", loginBean.getUserName());
                return "success";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "login";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "login";
        }
    }
}
