package com.crg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TokenController {

    @Resource(name = "tokenServices")
    private ConsumerTokenServices tokenServices;

    @Resource(name = "tokenStore")
    private TokenStore tokenStore;

    @GetMapping("/tokens/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PreAuthorize("hasRole('ADMIN')")
    public List<String> getTokens(@PathVariable String clientId) {
        return Optional.ofNullable(tokenStore.findTokensByClientId(clientId)).orElse(Collections.emptyList())
                .stream()
                .map(OAuth2AccessToken::getValue)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/oauth/token/revokeById/{tokenId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public void revokeToken(@PathVariable String tokenId) {
        tokenServices.revokeToken(tokenId);
    }

    @DeleteMapping("/tokens/revokeRefreshToken/{tokenId:.*}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String revokeRefreshToken(@PathVariable String tokenId) {
        if (tokenStore instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenStore).removeRefreshToken(tokenId);
        }
        return tokenId;
    }
}