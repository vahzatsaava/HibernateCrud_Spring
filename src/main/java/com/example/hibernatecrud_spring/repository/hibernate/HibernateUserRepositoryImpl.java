package com.example.hibernatecrud_spring.repository.hibernate;

import com.example.hibernatecrud_spring.model.Role;
import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import com.example.hibernatecrud_spring.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Component
public class HibernateUserRepositoryImpl implements UserRepository {
    private final String FIND_BY_ID_QUERY = "select users.id,username,email,first_name,last_name,users.password,users.status from users left join events e on users.id = e.users_id\n" +
            "left join user_roles ur on users.id = ur.user_id where users.id  = ?";
    private final String FIND_BY_USER_NAME = "select users.id,username,email,first_name,last_name,users.password,users.status from users left join events e on users.id = e.users_id\n" +
            "left join user_roles ur on users.id = ur.user_id where users.username  = ?";
    private final String GET_ALL_USERS = "select * from users";


    @Override
    public User add(User user) {
        try (Session session = HibernateUtils.getSession()) {
            session.save(user);
            return user;
        }
    }

    @Override
    public User update(User user) {
        try (Session session = HibernateUtils.getSession()) {
            session.getTransaction().begin();
            session.merge(user);
            session.getTransaction().commit();
        }
        return user;
    }

    @Override

    public User find(Long id) {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createNativeQuery(FIND_BY_ID_QUERY, User.class);
            query.setParameter(1, id);
            return (User) query.getSingleResult();
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtils.getSession()) {

            Query query = session.createNativeQuery(GET_ALL_USERS,User.class);
            return query.getResultList();
        }
    }


    @Override
    public void delete(Long id) {
        try (Session session = HibernateUtils.getSession()) {
            session.getTransaction().begin();
            Query query = session.createQuery("delete User as U where U.id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }

    }

    @Override
    public User findByUserName(String userName) {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createNativeQuery(FIND_BY_USER_NAME, User.class);
            query.setParameter(1, userName);
            return (User) query.getSingleResult();
        }
    }
}
