package org.holy.wcoa.dao;

import java.util.List;

public interface BaseDao<T> {

    int save(T t);

    void delete(Object id);

    void update(T t);

    T findOne(Object id);

    List<T> findAll();

    int count();
}
