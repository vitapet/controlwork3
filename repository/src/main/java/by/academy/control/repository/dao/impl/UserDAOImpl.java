package by.academy.control.repository.dao.impl;

import by.academy.control.repository.dao.IUserDAO;
import by.academy.control.repository.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByLogin(String login) {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
