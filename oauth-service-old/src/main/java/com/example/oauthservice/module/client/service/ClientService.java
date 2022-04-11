package com.example.oauthservice.module.client.service;


import com.example.oauthservice.module.client.domain.ClientVO;
import com.example.oauthservice.module.client.jpa.entity.ClientEntity;
import com.example.oauthservice.module.client.jpa.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class ClientService implements ClientDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;



    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientEntity client = clientRepository.findClientEntityByClientId(clientId);
        ClientVO clientVO = client == null ? null :
                //modelMapper.map(client,ClientVO.class);
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

    @Transactional
    public ClientVO saveClient(ClientVO clientVO) {
        ClientEntity client =  modelMapper.map(clientVO,ClientEntity.class);
        ClientEntity add =  clientRepository.save(client);
        return modelMapper.map(add,ClientVO.class);
    }


}
