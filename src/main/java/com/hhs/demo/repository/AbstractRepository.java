package com.hhs.demo.repository;

import com.hhs.demo.model.AbstractEntity;
import com.hhs.demo.context.IDataContext;

import java.util.Collection;
import java.util.UUID;

public abstract class AbstractRepository<T extends AbstractEntity> implements IDataContext<T> {

    protected final IDataContext<T> DB_CONTEXT;

    public AbstractRepository(IDataContext<T> context){
        DB_CONTEXT = context;
    }

    @Override
    public T getById(UUID id) {
        return DB_CONTEXT.getById(id);
    }

    @Override
    public Collection<T> getAll() {
        return DB_CONTEXT.getAll();
    }

    @Override
    public void add(T entity) {
        DB_CONTEXT.add(entity);
    }

    @Override
    public void delete(UUID id) {
        DB_CONTEXT.delete(id);
    }

    @Override
    public void update(T t) {
        DB_CONTEXT.update(t);
    }
}