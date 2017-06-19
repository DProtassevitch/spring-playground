package by.hector.project.dao;


import by.hector.project.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T> extends BaseEntity{

    void save(T entity);

        List<T> findAll();

}
