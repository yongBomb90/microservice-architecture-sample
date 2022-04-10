package com.example.oauthservice.module.client.service;

import ch.qos.logback.core.net.server.Client;
import com.example.oauthservice.module.client.domain.ClientVO;
import com.example.oauthservice.module.client.jpa.entity.ClientEntity;
import com.example.oauthservice.module.client.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;


@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
//        return ClientVO.builder()
//                .clientSecret(passwordEncoder.encode("qwer1234"))
//                .clientId("client")
//                .authorities("user,admin")
//                .scope("read,write,trust")
//                .accessTokenValiditySeconds(10000)
//                .refreshTokenValiditySeconds(100000)
//                .grantTypes("authorization_code,implicit,password,client_credentials,refresh_token")
//                .redirectUri("/oauth-callback")
//                .autoApprove(false)
//                .resourceIds("client")
//                .build();
        ClientEntity client = clientRepository.findClientEntityByClientId(clientId);
        ClientVO clientVO = client == null ? null :
                ClientVO.builder()
                   .clientSecret(client.getClientSecret())
                  .clientId(client.getClientId())
                  .authorities(client.getAuthorities())
                  .scope(client.getScope())
                  .accessTokenValiditySeconds(client.getAccessTokenValiditySeconds())
                  .refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
                  .grantTypes(client.getGrantTypes())
                  .redirectUri(client.getRedirectUri())
                  .autoApprove(client.isAutoApprove())
                  .resourceIds(client.getResourceIds())
                  .build();
        return clientVO;
    }

}
