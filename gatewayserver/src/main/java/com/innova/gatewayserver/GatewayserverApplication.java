package com.innova.gatewayserver;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}
	
	   @Bean
	    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	        return builder.routes()
	            .route(p -> p
	                .path("/product/**")
	                .filters(f -> f.rewritePath("/innova/product/(?<segment>.*)","/${segment}")
	                                .addResponseHeader("X-Response-Time",new Date().toString()))
	                .uri("lb://PRODUCT")).
	            route(p -> p
	                    .path("/order/**")
	                    .filters(f -> f.rewritePath("/innova/order/(?<segment>.*)","/${segment}")
	                            .addResponseHeader("X-Response-Time",new Date().toString()))
	                    .uri("lb://ORDER")).build();
	    }
	

}
