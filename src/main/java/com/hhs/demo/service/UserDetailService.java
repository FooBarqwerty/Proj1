package com.hhs.demo.service;

import com.hhs.demo.context.exception.InvalidEmailException;
import com.hhs.demo.context.exception.InvalidGradeException;
import com.hhs.demo.model.User;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDetailService {

    private final PasswordEncoder PASSWORD_ENCODER;
    private final EmailValidator EMAIL_VALIDATOR;

    @Autowired
    public UserDetailService(PasswordEncoder password_encoder, EmailValidator email_validator) {
        PASSWORD_ENCODER = password_encoder;
        EMAIL_VALIDATOR = email_validator;
    }

    public User setPassword(User user, String password){
        user.setPassword(PASSWORD_ENCODER.encode(password));
        return user;
    }

    public User setEmail(User user, String email) {
        if (! EMAIL_VALIDATOR.isValid(email)) throw new InvalidEmailException();
        user.setEmail(email);
        return user;
    }

    public User addTakenQuiz(User user, UUID quiz, int mark) {
        user.addTakenQuiz(quiz, mark);
        return user;
    }

    public User updateGrade(User user, UUID quiz, int grade) {
        if(! (grade >= 0 && grade <= 100)) throw new InvalidGradeException();
        user.updateGrade(quiz,grade);
        return user;
    }

    public User createUser(String name, String email, String password){
        User temp = new User(name);
        setEmail(temp, email);
        setPassword(temp, password);
        return temp;
    }
}
