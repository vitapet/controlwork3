package by.academy.control.repository.dao.impl;

import by.academy.control.repository.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> entityClass;

    public GenericDAOImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(Long id) {
        T t = getSession().get(this.entityClass, id);
        return t;
    }

    @Override
    public List<T> getAll() {
        List<T> list = getSession().createCriteria(this.entityClass).list();
        return list;
    }

    @Override
    public void create(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }
}
