package com.potatosaucevfx.springbootsandbox.service;

import com.potatosaucevfx.springbootsandbox.model.Login;
import com.potatosaucevfx.springbootsandbox.model.User;
import com.potatosaucevfx.springbootsandbox.service.datamappers.UserMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Component
public class UserService implements UserDetailsService {

    // Logger for class
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        User user = jdbcTemplate.queryForObject(sql, new Object[]{email}, new UserMapper());
        return user;
    }

    public Login getLoginByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE email = ?";
        Login login = jdbcTemplate.queryForObject(sql, new Object[]{email}, new RowMapper<Login>() {
            @Override
            public Login mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();

                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setEnabled(rs.getBoolean("enabled"));

                Login login = new Login(rs.getString("email"), rs.getString("password"), rs.getBoolean("enabled"), user);

                return login;
            }
        });

        logger.info("Logging in: " + login);

        return login;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM Users";
        List<User> users = jdbcTemplate.query(sql, new UserMapper());
        return users;
    }

    public boolean addUser(User user, String role) {
        if (!(role.equalsIgnoreCase("ADMIN") || role.equalsIgnoreCase("USER"))) {
            logger.error("Add User requires a role of \"ADMIN\" or \"USER\"!");
            return false;
        }

        logger.info("Adding new user: " + user);

        String SQL = "INSERT INTO Users(firstName, lastName, email, password, enabled)"
                + " VALUES(?, ?, ?, ?, true)";
        jdbcTemplate.update(SQL,
                new Object[]{
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    new BCryptPasswordEncoder().encode(user.getPassword())});

        SQL = "INSERT INTO User_Roles(email, role) VALUES(?, ?)";
        jdbcTemplate.update(SQL, new Object[]{user.getEmail(), "ROLE_" + role.toUpperCase()});

        return true;
    }

    public boolean removeUser(String email) {
        String SQL = "UPDATE Users SET enabled = false WHERE email = ?";
        jdbcTemplate.update(SQL, new Object[]{email});
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Login login = this.getLoginByEmail(email);

        if (login == null) {
            logger.debug("User " + email + " not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        return login;

    }
}
