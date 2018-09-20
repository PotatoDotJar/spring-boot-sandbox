package com.potatosaucevfx.springbootsandbox.controller;

import com.potatosaucevfx.springbootsandbox.model.Person;
import com.potatosaucevfx.springbootsandbox.service.JsonService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Richard Nader Jr. <heelyskidrj@gmail.com>
 */
@RestController
public class HomeRestController {
    
    @RequestMapping("/home/tableData")
    public ArrayList<Person> greeting() {
        return JsonService.readTableData();
    }
}
