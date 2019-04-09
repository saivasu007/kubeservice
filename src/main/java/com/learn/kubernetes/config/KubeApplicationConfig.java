package com.learn.kubernetes.config;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.apis.AppsV1Api;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Configuration
@EnableSwagger2
public class KubeApplicationConfig extends WebMvcConfigurationSupport {

	@Bean
	public CoreV1Api getCoreV1Api() throws Exception {
		ApiClient client = Config.defaultClient();
		io.kubernetes.client.Configuration.setDefaultApiClient(client);
		return new CoreV1Api();
	}

	@Bean
	public AppsV1Api getAppsV1Api() throws Exception {
		ApiClient client = Config.defaultClient();
		io.kubernetes.client.Configuration.setDefaultApiClient(client);
		return new AppsV1Api();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
													  .apis(withClassAnnotation(RestController.class))
													  .paths(PathSelectors.any())
													  .build()
				                                      .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Kubernetes Service REST API", "Simple Kube Service API.", "1.0", "Terms of service",
						   new Contact("Srinivas Thungathurti", "www.srinivast.com", "srinivast@dataserv.com"), "License of API",
						   "API license URL", Collections.emptyList());
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
