package com.hhs.demo.controller;

import com.hhs.demo.controller.data.UserCtrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppCtrl {

    private final UserCtrl userCtrl;

    @Autowired
    private AppCtrl(UserCtrl userCtrl) {
        this.userCtrl = userCtrl;
    }

    public void run(){
        userCtrl.createUser("tommie", "test@mail.com", "password");
        userCtrl.getAll().forEach(System.out::println);
    }
}