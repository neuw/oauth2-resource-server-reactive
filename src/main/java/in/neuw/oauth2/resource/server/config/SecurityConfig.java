package in.neuw.oauth2.resource.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;

@Configuration
public class SecurityConfig {

    // filter to protect all the urls matching /v1/** with JWT based oauth TOKEN
    @Bean
    public SecurityWebFilterChain springSecurityFilterChainJwt(ServerHttpSecurity http) {
        http
                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/v1/**"))
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer().jwt();
        return http.build();
    }

    // filter to protect all the urls matching /v2/** with opaque oauth TOKEN
    @Bean
    public SecurityWebFilterChain springSecurityFilterChainOpaque(ServerHttpSecurity http) {
        http
                .securityMatcher(new PathPatternParserServerWebExchangeMatcher("/v2/**"))
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer().opaqueToken();
        return http.build();
    }

}
