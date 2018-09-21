package com.potatosaucevfx.springbootsandbox.service.datamappers;

import com.potatosaucevfx.springbootsandbox.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {
        Person p = new Person();

        p.setUserId(rs.getInt("id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setEmail(rs.getString("email"));
        p.setGender(rs.getString("gender"));
        p.setPhone(rs.getString("phone"));
        p.setAddress(rs.getString("address"));
        p.setCity(rs.getString("city"));
        p.setState(rs.getString("state"));
        p.setZipcode(rs.getInt("zip"));

        return p;
    }
}
