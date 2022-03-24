package com.hhs.demo.config;

import com.hhs.demo.context.IUserContext;
import com.hhs.demo.model.User;
import com.hhs.demo.context.IDataContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class UserDB implements IDataContext<User>, IUserContext {

    private final Collection<User> DB = new ArrayList<>();

    private Predicate<User> matchId(UUID id){
        return user -> user.ID.equals(id);
    }

    private Predicate<User> matchMail(String email){
        return user -> user.getEmail().equals(email);
    }

    private User queryDB(Predicate<User> pre){
        return (User) DB.stream().filter(pre);
    }

    @Override
    public User getById(UUID id) {
        return queryDB(matchId(id));
    }

    @Override
    public Collection<User> getAll() {
        return DB;
    }

    @Override
    public void add(User entity) {
        DB.add(entity);
    }

    @Override
    public void delete(UUID id) {
        DB.remove(queryDB(matchId(id)));
    }

    @Override
    public void update(User updatedUser) {
        DB.removeIf(user -> user.ID == updatedUser.ID);
        DB.add(updatedUser);
    }

    @Override
    public UUID uuidForEmail(String email) {
        return queryDB(matchMail(email)).ID;
    }
}
