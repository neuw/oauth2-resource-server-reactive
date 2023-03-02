package in.neuw.oauth2.resource.server.controllers;

import in.neuw.oauth2.resource.server.models.Pong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/v1/")
public class PingControllerV1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("ping")
    public Mono<Pong> getPongByJwtToken(ServerWebExchange exchange) {
        // comment the following line, logging it only for the incoming Authorization header for debugging purpose
        logger.info("the auth header value is - {}", exchange.getRequest().getHeaders().get("Authorization"));
        return Mono.justOrEmpty(new Pong("pong", true, new Date().getTime(), HttpMethod.GET.name(), "v1"));
    }

    @PostMapping("ping/post")
    public Mono<Pong> postPongByJwtToken(ServerWebExchange exchange) {
        // comment the following line, logging it only for the incoming Authorization header for debugging purpose
        logger.info("the auth header value is - {}", exchange.getRequest().getHeaders().get("Authorization"));
        return Mono.justOrEmpty(new Pong("pong", true, new Date().getTime(), HttpMethod.POST.name(), "v1"));
    }

}
