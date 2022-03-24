package com.hhs.demo.context;

import com.hhs.demo.model.AbstractEntity;

import java.util.Collection;
import java.util.UUID;

public interface IDataContext<T extends AbstractEntity> {

    T getById(UUID id);
    Collection<T> getAll();
    void add(T entity);
    void delete(UUID id);
    void update(T t);
}