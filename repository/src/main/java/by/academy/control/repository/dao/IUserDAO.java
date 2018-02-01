package by.academy.control.repository.dao;

import by.academy.control.repository.model.User;

public interface IUserDAO extends GenericDAO<User>{
    User getByLogin(String login);
}
