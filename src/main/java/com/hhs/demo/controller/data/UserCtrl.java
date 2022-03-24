package com.hhs.demo.controller.data;

import com.hhs.demo.context.IUserContext;
import com.hhs.demo.model.User;
import com.hhs.demo.repository.UserRepository;
import com.hhs.demo.service.SessionService;
import com.hhs.demo.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class UserCtrl extends AbstractDataCtrl<User> {

    private final UserDetailService USER_DETAIL_SERVICE;
    private final SessionService SESSION;

    @Autowired
    UserCtrl(UserRepository<IUserContext> repository, UserDetailService user_detail_service, SessionService session) {
        super(repository);
        USER_DETAIL_SERVICE = user_detail_service;
        SESSION = session;
    }

    public void login(String password, String email) {
        java.util.UUID idTemp = ((IUserContext) REPOSITORY).uuidForEmail(email);
        SESSION.login(password, REPOSITORY.getById(idTemp).getPassword() ,idTemp);
    }

    public void logout() {
        SESSION.logout();
    }

    private User sessionUser() {
        return REPOSITORY.getById(SESSION.getID());
    }

    public void setPassword(String password) {
        SESSION.loggedIn();
        REPOSITORY.update(USER_DETAIL_SERVICE.setPassword(sessionUser(), password));
    }

    public void setEmail(String email) {
        SESSION.loggedIn();
        REPOSITORY.update(USER_DETAIL_SERVICE.setEmail(sessionUser(), email));
    }
    public void addTakenQuiz(User user, UUID quiz, int grade) {
        SESSION.loggedIn();
        REPOSITORY.update(USER_DETAIL_SERVICE.addTakenQuiz(sessionUser(),quiz,grade));
    }

    public void updateGrade(User user, UUID quiz, int grade) {
        SESSION.loggedIn();
        REPOSITORY.update(USER_DETAIL_SERVICE.updateGrade(sessionUser(),quiz,grade));
    }

    public void createUser(String name) {
        createUser(name, null, null);
    }

    public void createUser(String name, String email, String password) {
        REPOSITORY.add(USER_DETAIL_SERVICE.createUser(name, email, password));
    }

    public String getEmail() {
        SESSION.loggedIn();
        return sessionUser().getEmail();
    }
}