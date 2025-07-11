package com.starline.gateway;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class StarlineGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarlineGatewayApplication.class, args);
	}

	@Bean
	public OpenAPI gatewayOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Gateway API")
						.description("Exposes Swagger UI for routed microservices")
						.version("v1"))
				.servers(List.of(
						new Server().url("/") // or your public gateway path
				));
	}

}
