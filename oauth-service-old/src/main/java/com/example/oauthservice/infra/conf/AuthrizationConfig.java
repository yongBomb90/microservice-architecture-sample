package com.example.oauthservice.infra.conf;

import com.example.oauthservice.module.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.web.servlet.oauth2.client.AuthorizationCodeGrantDsl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableAuthorizationServer
@Configuration
public class AuthrizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    TokenStore tokenStore;

    @Autowired
    ApprovalStore approvalStore;

    @Autowired
    AccessTokenConverter accessTokenConverter;

    @Autowired
    UserDetailsService userDetailsService;

    @Resource
    AuthenticationManager authenticationManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    ClientService clientService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
        security.passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("client")
//                .secret(passwordEncoder.encode("qwer1234"))
//                .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials", "refresh_token")
//                .scopes("read","write","trust")
//                .accessTokenValiditySeconds(10*60)
//                .refreshTokenValiditySeconds(60*10*60)
//        ;

        clients.withClientDetails(clientService);

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager )
                .tokenStore(tokenStore)
                .approvalStore(approvalStore)
                .accessTokenConverter(accessTokenConverter)
                .userDetailsService(userDetailsService)
        ;
    }
}
