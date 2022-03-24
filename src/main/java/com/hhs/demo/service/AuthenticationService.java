package com.hhs.demo.service;

import com.hhs.demo.config.SecurityConfig.Authenticator;
import com.hhs.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final Authenticator AUTHENTICATOR;

    @Autowired
    AuthenticationService(Authenticator authenticator, UserDetailService userDetailService){
        AUTHENTICATOR = authenticator;
    }

    public boolean authenticate(String password, String hash){
        return AUTHENTICATOR.authenticate(password, hash);
    }
}
