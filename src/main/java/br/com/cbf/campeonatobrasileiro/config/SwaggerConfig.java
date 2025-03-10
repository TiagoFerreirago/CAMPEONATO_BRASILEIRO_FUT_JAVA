package br.com.cbf.campeonatobrasileiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenApi() {
		
		return new OpenAPI().info(new Info()
				.title("Rest API Campeonato brasileiro com Java 17")
				.description("Rest Api que simula um campeonato brasileiro digital")
				.version("v1")
				.termsOfService("https:/www.cbf.com/temsofservice")
				.license(new License()
						.name("apache 2.0")
						.url("\"https:/www.cbf.com/license")));
		
	}
}

