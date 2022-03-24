package com.hhs.demo.service;

import com.hhs.demo.context.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionService {

    private UUID _loggedInUser = null;
    private final AuthenticationService AUTHENTICATION_SERVICE;

    @Autowired
    public SessionService(AuthenticationService authentication_service) {
        AUTHENTICATION_SERVICE = authentication_service;
    }

    public UUID getID(){
        return _loggedInUser;
    }

    public void login(String password, String hash, UUID id){
        _loggedInUser = AUTHENTICATION_SERVICE.authenticate(hash, password)
                ? id : null;
    }

    public void logout(){
        _loggedInUser = null;
    }

    public void loggedIn() {
        if (_loggedInUser == null) throw new LoginException();
    }

}
