package com.example.oauthservice.module.client.domain.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ClientSaveForm {

    @NotBlank
    private String clientId;
    @NotBlank
    private String clientSecret;
    @NotBlank
    private String resourceIds;
    @NotBlank
    private String scope;
    @NotBlank
    private String grantTypes;
    @NotBlank
    private String redirectUri;
    @NotBlank
    private String authorities;
    @NotNull
    private Integer accessTokenValiditySeconds;
    @NotNull
    private Integer refreshTokenValiditySeconds;

    private boolean autoApprove;
}
