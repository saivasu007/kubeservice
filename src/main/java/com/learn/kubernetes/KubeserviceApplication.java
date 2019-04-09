package com.learn.kubernetes;

import com.learn.kubernetes.config.KubeApplicationConfig;
import com.learn.kubernetes.rest.resource.KubeResource;
import com.learn.kubernetes.rest.service.KubeService;
import com.learn.kubernetes.rest.service.KubeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackageClasses = { KubeApplicationConfig.class, KubeService.class, KubeServiceImpl.class, KubeResource.class,
									  CommandLineAppStartupRunner.class })
public class KubeserviceApplication extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(KubeserviceApplication.class, args);
	}
}
