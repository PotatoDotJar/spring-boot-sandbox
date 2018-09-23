package com.potatosaucevfx.springbootsandbox;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author PotatoSauceVFX <rj@potatosaucevfx.com>
 */
@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfig {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource dataSource() {
        System.out.println("URL: " + env.getProperty("mysql.url"));
        System.out.println("UN: " + env.getProperty("mysql.username"));
        System.out.println("PW: " + env.getProperty("mysql.password"));
        System.out.println("Driver: " + env.getProperty("mysql.driver"));
        return DataSourceBuilder
                .create()
                .username(env.getProperty("mysql.username"))
                .password(env.getProperty("mysql.password"))
                .url(env.getProperty("mysql.url"))
                .driverClassName(env.getProperty("mysql.driver"))
                .build();
    }

}
