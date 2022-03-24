package com.hhs.demo.repository;

import com.hhs.demo.config.UserDB;
import com.hhs.demo.context.IUserContext;
import com.hhs.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserRepository<T extends IUserContext> extends AbstractRepository<User> implements IUserContext {

    @Autowired
    public UserRepository(UserDB context) {
        super(context);
    }

    @Override
    public UUID uuidForEmail(String email){
        return ((IUserContext) DB_CONTEXT).uuidForEmail(email);
    }
}