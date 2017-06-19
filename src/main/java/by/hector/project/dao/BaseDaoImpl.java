package by.hector.project.dao;


import by.hector.project.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    @Override
    public void save(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(entity);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<T> resultList = session.createQuery("from "+ modelClass.getSimpleName(), modelClass).getResultList();


        return resultList;
    }
}
