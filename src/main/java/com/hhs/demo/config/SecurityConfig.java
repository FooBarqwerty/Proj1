package com.hhs.demo.config;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfig {

    @Bean
    EmailValidator emailValidator() {
        return EmailValidator.getInstance();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Component
    public static class Authenticator{
        public boolean authenticate(String password, String hash) {
            return BCrypt.checkpw(password, hash);
        }
    }
}
