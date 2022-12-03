package bj.prexed.apigateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ResourceServerSecurityConfig {

    /*@Bean
    public SecurityWebFilterChain configureResourceServer(ServerHttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeExchange().pathMatchers("/actuator/health/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/webjars/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/swagger-ui.html").permitAll()
                .pathMatchers(HttpMethod.GET,"/swagger-resources/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/v3/api-docs/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/user-service/v3/api-docs/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/dept-service/v3/api-docs/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/organization-service/v3/api-docs/**").permitAll()

                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer().jwt().and()
                .and().build();
    }*/
}