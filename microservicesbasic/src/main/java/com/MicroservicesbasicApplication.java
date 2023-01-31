
package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaServer
@EnableFeignClients
//(exclude = {DataSourceAutoConfiguration.class },
//scanBasePackages = {"com.application","com.something"})
public class MicroservicesbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesbasicApplication.class, args);
	}

}
