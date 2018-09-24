package com.potatosaucevfx.springbootsandbox.controller;

import com.potatosaucevfx.springbootsandbox.model.User;
import com.potatosaucevfx.springbootsandbox.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService uSvc;

    @RequestMapping("/encrypt")
    public String encryptPw(@RequestParam(value = "pw") String pw) {
        return new BCryptPasswordEncoder().encode(pw);
    }

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return uSvc.getAllUsers();
    }

}
