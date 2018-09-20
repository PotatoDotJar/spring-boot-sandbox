package com.potatosaucevfx.springbootsandbox.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
@RestController
public class HomeRestController {
    
    @RequestMapping("/home/tableData")
    public String greeting() {
        return "yes";
    }
}
