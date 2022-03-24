package com.hhs.demo.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class User extends AbstractEntity {

    public final String NAME;
    private String _email;
    private String _password;
    public final Map<UUID, Integer> TAKEN_QUIZZES =  new HashMap<>();

    public User(String name) {
        NAME = name;
    }

    public void setPassword(String password){
        _password = password;
    }

    public String getPassword() {
        return _password;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public void addTakenQuiz(UUID quiz, int grade){
        TAKEN_QUIZZES.put(quiz, grade);
    }

    public void updateGrade(UUID quiz, int grade){
        TAKEN_QUIZZES.replace(quiz,grade);
    }

    @Override
    public String toString() {
        return "User {" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", _email='" + _email + '\'' +
                ", _password='" + _password + '\'' +
                ", TAKEN_QUIZZES=" + TAKEN_QUIZZES +
                '}';
    }
}
