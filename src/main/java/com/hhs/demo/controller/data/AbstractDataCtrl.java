package com.hhs.demo.controller.data;

import com.hhs.demo.model.AbstractEntity;
import com.hhs.demo.context.IDataContext;
import com.hhs.demo.repository.AbstractRepository;

import java.util.Collection;
import java.util.UUID;

public abstract class AbstractDataCtrl<T extends AbstractEntity> implements IDataContext<T> {

    public final AbstractRepository<T> REPOSITORY;

    public AbstractDataCtrl(AbstractRepository<T> repository) {
        REPOSITORY = repository;
    }

    @Override
    public void add(T t) {
        REPOSITORY.add(t);
    }

    @Override
    public T getById(UUID id) {
        return REPOSITORY.getById(id);
    }

    @Override
    public Collection<T> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public void delete(UUID id) {
        REPOSITORY.delete(id);
    }

    @Override
    public void update(T t) {
        REPOSITORY.update(t);
    }
}
