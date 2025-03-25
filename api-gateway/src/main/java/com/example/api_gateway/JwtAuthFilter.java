//package com.example.api_gateway;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//
//@Component
//public class JwtAuthFilter implements WebFilter {
//
//    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("MySecretKeyForJWTTokenAuthentication".getBytes(StandardCharsets.UTF_8));
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//
//        if (request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//            String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                String token = authHeader.substring(7);
//
//                try {
//                    Claims claims = Jwts.parserBuilder()
//                            .setSigningKey(SECRET_KEY)
//                            .build()
//                            .parseClaimsJws(token)
//                            .getBody();
//
//                    exchange.getRequest().mutate()
//                            .header("X-User-Id", claims.getSubject())
//                            .header("X-User-Role", claims.get("role", String.class))
//                            .build();
//
//                } catch (Exception e) {
//                    exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
//                    return exchange.getResponse().setComplete();
//                }
//            }
//        }
//        return chain.filter(exchange);
//    }
//}
