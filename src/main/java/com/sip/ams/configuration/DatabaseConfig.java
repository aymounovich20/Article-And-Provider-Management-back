package com.sip.ams.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
@Configuration
public class DatabaseConfig {
@Value("${spring.datasource.url}")
private String dbUrl;
@Bean
public DataSource dataSource() {
HikariConfig config = new HikariConfig();
config.setJdbcUrl(dbUrl);
return new HikariDataSource(config);
}
}
