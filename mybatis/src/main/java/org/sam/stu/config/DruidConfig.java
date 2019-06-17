package org.sam.stu.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Primary;

@Configuration
public class DruidConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	 
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean(name="dataSource")
	@Primary
	public DruidDataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxActive(20);//最大连接池数量
		return dataSource;
	}
}
