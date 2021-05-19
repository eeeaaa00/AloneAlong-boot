package com.dwu.alonealong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.dwu.alonealong"})
@MapperScan(basePackages = "com.dwu.alonealong.dao.mybatis.mapper")
public class AloneAlongBootApplication extends SpringBootServletInitializer {
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AloneAlongBootApplication.class);
	}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AloneAlongBootApplication.class, args);
    }
}