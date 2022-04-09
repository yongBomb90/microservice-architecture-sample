package com.example.oauthservice.module.client.service;

import com.example.oauthservice.module.client.domain.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;


@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return ClientVO.builder()
                .clientSecret(passwordEncoder.encode("qwer1234"))
                .clientId("client")
                .authorities("user")
                .scope("read,write,trust")
                .accessTokenValiditySeconds(10000)
                .refreshTokenValiditySeconds(100000)
                .grantTypes("authorization_code,implicit,password,client_credentials,refresh_token")
                .redirectUri("/oauth-callback")
                .autoApprove(false)
                .resourceIds("client")
                .build();
    }

}
