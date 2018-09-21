package com.potatosaucevfx.springbootsandbox.controller;

import com.potatosaucevfx.springbootsandbox.model.Person;
import com.potatosaucevfx.springbootsandbox.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
@RestController
public class HomeRestController {

    @Autowired
    PersonService ps;

    @RequestMapping("/users/all")
    public List<Person> allUsers() {
        return ps.getAllUsers();
    }
}
