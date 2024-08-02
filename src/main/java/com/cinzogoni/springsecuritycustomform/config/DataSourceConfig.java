package com.cinzogoni.springsecuritycustomform.config;


import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.cinzogoni.springsecuritycustomform.repositories")
public class DataSourceConfig {

    private final Environment env;
    @Autowired
    public DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .build();
    }
}
