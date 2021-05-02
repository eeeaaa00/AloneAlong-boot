package com.dwu.alonealong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.dwu.alonealong"})
public class AloneAlongBootApplication extends SpringBootServletInitializer {
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AloneAlongBootApplication.class);
	}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AloneAlongBootApplication.class, args);
    }
}