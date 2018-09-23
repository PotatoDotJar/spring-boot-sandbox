package com.potatosaucevfx.springbootsandbox.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            /* The user is already logged in :) */
            RedirectView view = new RedirectView("/", true);
            view.setExposeModelAttributes(false);
            return new ModelAndView(view);
        }

        return new ModelAndView("login");
    }
}
