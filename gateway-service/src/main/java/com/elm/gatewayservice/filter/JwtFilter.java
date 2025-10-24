package com.elm.gatewayservice.filter;

import io.jsonwebtoken.Jwts;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class JwtFilter implements WebFilter {

    private final PublicKey publicKey;

    public JwtFilter() throws Exception {
        this.publicKey = loadPublicKey();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();

        if (path.startsWith("/auth-service/auth/register") ||
                path.startsWith("/auth-service/auth/login") ||
                path.startsWith("/auth-service/auth/token") ) {
            return chain.filter(exchange); // skip JWT check
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return unauthorized(exchange, "Missing or invalid Authorization header");
        }

        String token = authHeader.substring(7);
        try {
            Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token); // throws if invalid

            return chain.filter(exchange); // continue if valid

        } catch (Exception e) {
            return unauthorized(exchange, "Invalid or expired token");
        }
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange, String msg) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    private PublicKey loadPublicKey() throws Exception {
        InputStream inputStream = new ClassPathResource("keys/public_key.pem").getInputStream();
        String key = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8)
                .replaceAll("-----\\w+ PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
        byte[] decoded = Base64.getDecoder().decode(key);
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
    }
}
