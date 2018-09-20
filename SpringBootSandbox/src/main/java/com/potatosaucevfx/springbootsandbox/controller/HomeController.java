package com.potatosaucevfx.springbootsandbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// Home Controller
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView root() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "TestMessage");
        mav.addObject("page", "home");
        return mav;
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("message", "TestMessage");
        mav.addObject("page", "home");
        return mav;
    }

    @RequestMapping("/about")
    public ModelAndView about() {
        ModelAndView mav = new ModelAndView("about");
        mav.addObject("page", "about");
        return mav;
    }

}
