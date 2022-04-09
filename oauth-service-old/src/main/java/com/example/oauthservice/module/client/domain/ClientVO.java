package com.example.oauthservice.module.client.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;

@Builder
public class ClientVO implements ClientDetails {

    private String clientId;
    private String clientSecret;
    private String resourceIds;
    private String scope;
    private String grantTypes;
    private String redirectUri;
    private String authorities;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private boolean autoApprove;

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceIds != null ?
                new HashSet<>(Arrays.asList(resourceIds.split(",")))
                : null;
    }

    @Override
    public boolean isSecretRequired() {
        return StringUtils.isNotEmpty(clientSecret);
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return StringUtils.isNotEmpty(scope);
    }

    @Override
    public Set<String> getScope() {
        return this.scope != null ?
                new HashSet<>(Arrays.asList(scope.split(",")))
                : null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.grantTypes != null ?
                new HashSet<>(Arrays.asList(grantTypes.split(",")))
                : null;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.redirectUri != null ?
                new HashSet<>(Arrays.asList(redirectUri.split(",")))
                : null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return StringUtils.isNotEmpty(authorities) ?
                AuthorityUtils.createAuthorityList(authorities.split(","))
                : new ArrayList<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

}
