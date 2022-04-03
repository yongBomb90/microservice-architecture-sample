package com.example.oauthservice.infra.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

@Configuration
public class WebConfig {

//    {
//        "grant_type" : "password"
//            ,"password" : "password"
//            ,"username" : "username"
//    }
    @Bean
    UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDetails user = new User("userName", "{noop}password", Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
                return user;
            }
        };
    }


}
