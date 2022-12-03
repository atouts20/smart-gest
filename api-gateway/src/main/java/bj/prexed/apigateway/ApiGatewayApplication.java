package bj.prexed.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;


import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
//@EnableHystrix
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	/*@Bean
	DiscoveryClientRouteDefinitionLocator discoveryClientRouteDefinitionLocator(
			ReactiveDiscoveryClient reactiveDiscoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties
	){
		return new DiscoveryClientRouteDefinitionLocator ( reactiveDiscoveryClient,discoveryLocatorProperties );
	}*/

	@Bean
	public CorsWebFilter corsWebFilter() {
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins( Collections.singletonList("http://localhost:9000"));
		corsConfig.setAllowedMethods( Arrays.asList("GET", "POST", "OPTIONS", "HEAD", "PUT"));
		corsConfig.addAllowedHeader("Access-Control-Allow-Origin");

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
}
