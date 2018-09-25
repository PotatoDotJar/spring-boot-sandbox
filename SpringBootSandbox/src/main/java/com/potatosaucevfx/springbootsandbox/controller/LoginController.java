package com.potatosaucevfx.springbootsandbox.controller;

import com.potatosaucevfx.springbootsandbox.model.User;
import com.potatosaucevfx.springbootsandbox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Controller
public class LoginController {

    @Autowired
    private UserService uSvc;

    @RequestMapping("/login")
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            RedirectView view = new RedirectView("/", true);
            view.setExposeModelAttributes(false);
            return new ModelAndView(view);
        }

        return new ModelAndView("login");
    }

    @RequestMapping("/signup")
    public ModelAndView signup() {

        ModelAndView mav = new ModelAndView("signup");
        mav.addObject("user", new User());

        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView signupSubmit(@ModelAttribute User user) {
        if (uSvc.addUser(user, "USER")) {
            RedirectView view = new RedirectView("/login", true);
            view.setExposeModelAttributes(false);
            return new ModelAndView(view);
        } else {
            RedirectView view = new RedirectView("/signup?error=true", true);
            view.setExposeModelAttributes(false);
            return new ModelAndView(view);
        }
    }

}
