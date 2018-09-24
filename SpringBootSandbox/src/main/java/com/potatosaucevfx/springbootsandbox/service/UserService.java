package com.potatosaucevfx.springbootsandbox.service;

import com.potatosaucevfx.springbootsandbox.model.User;
import com.potatosaucevfx.springbootsandbox.service.datamappers.UserMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Component
public class UserService {

    // Logger for class
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{email}, new UserMapper());
        return user;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    public boolean addUser(User user, String role) {

        if (!role.equalsIgnoreCase("ADMIN") || !role.equalsIgnoreCase("USER")) {
            return false;
        }

        String sql = "INSERT INTO Users(firstName, lastName, email, password, enabled)"
                + " VALUES(?, ?, ?, ?, true)";

        int userAddStatus
                = jdbcTemplate.update(sql,
                        new Object[]{user.getFirstName(),
                            user.getLastName(),
                            user.getEmail(),
                            new BCryptPasswordEncoder().encode(user.getPassword())});

        int userAuthStatus = 0;
        if (userAddStatus >= 1) {
            sql = "INSERT INTO User_Roles(email, role)"
                    + " VALUES(?, ?)";
            userAuthStatus = jdbcTemplate.update(sql, new Object[]{user.getEmail(), "ROLE_" + role.toUpperCase()});
        } else {
            return false;
        }

        if (userAddStatus >= 1 && userAuthStatus >= 1) {
            return true;
        } else {
            return false;
        }
    }

}
