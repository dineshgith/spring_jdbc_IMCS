package com.employee.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "classpath:jdbc.properties" })
@ComponentScan(basePackages ="com.employee")
public class EmployeeConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(environment.getRequiredProperty("driverClassName"));
		ds.setUrl(environment.getRequiredProperty("url"));
		ds.setUsername(environment.getRequiredProperty("username"));
		ds.setPassword(environment.getRequiredProperty("password"));
		return ds;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		jt.setResultsMapCaseInsensitive(true);
		return jt;
	}
}
