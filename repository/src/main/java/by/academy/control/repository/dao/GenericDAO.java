package by.academy.control.repository.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {
    T getById(Long id);

    List<T> getAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
