package com.potatosaucevfx.springbootsandbox.service;

import com.potatosaucevfx.springbootsandbox.model.Person;
import com.potatosaucevfx.springbootsandbox.service.datamappers.PersonMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Component
public class PersonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getAllUsers() {
        String sql = "SELECT * FROM PersonData";
        List<Person> people = jdbcTemplate.query(sql, new PersonMapper());
        return people;
    }

}
