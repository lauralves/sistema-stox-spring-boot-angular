package core.keycloak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(new Converter<Jwt, AbstractAuthenticationToken>() {
                            @Override
                            public AbstractAuthenticationToken convert(Jwt jwt) {
                                Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
                                Collection<String> roles = realmAccess.get("roles");
                                var grants = roles
                                        .stream()
                                        .map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());


                                return new JwtAuthenticationToken(jwt, grants);
                            }
                        })
                ));
        return http.build();
    }
}
