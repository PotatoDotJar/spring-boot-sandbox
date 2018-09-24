package com.potatosaucevfx.springbootsandbox.service.datamappers;

import com.potatosaucevfx.springbootsandbox.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();

        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setPassword(null);
        user.setEnabled(rs.getBoolean("enabled"));

        return user;
    }
}
