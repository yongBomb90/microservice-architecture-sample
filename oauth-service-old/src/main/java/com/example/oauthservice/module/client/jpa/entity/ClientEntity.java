package com.example.oauthservice.module.client.jpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
@Data
public class ClientEntity {

    @Id
    @Column(name = "SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @Column(name = "CLIENT_ID" , unique = true , length = 128)
    private String clientId;
    @Column(name = "CLIENT_SECRET")
    private String clientSecret;
    @Column(name = "RESOURCE_IDS")
    private String resourceIds;
    @Column(name = "SCOPE")
    private String scope;
    @Column(name = "GRANT_TYPES")
    private String grantTypes;
    @Column(name = "REDIRECT_URI")
    private String redirectUri;
    @Column(name = "AUTHORITIES")
    private String authorities;
    @Column(name = "ACCESS_TOKEN_VALIDITY_SECS")
    private Integer accessTokenValiditySeconds;
    @Column(name = "REFRESH_TOKEN_VALIDITY_SECS")
    private Integer refreshTokenValiditySeconds;
    @Column(name = "AUTO_APPROVE")
    private boolean autoApprove;


}
