package com.potatosaucevfx.springbootsandbox.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@RestController
@RequestMapping("/misc")
public class MiscRestController {

    @RequestMapping("/encrypt")
    public String encryptPw(@RequestParam(value = "pw") String pw) {
        return new BCryptPasswordEncoder().encode(pw);
    }

}
