package mahat.aviran.resource_server_poc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(customizer -> customizer
                        .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                        .anyRequest()
                        .authenticated())
                .oauth2ResourceServer().jwt();
        return http.build();
    }
}
