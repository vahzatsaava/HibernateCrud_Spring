package com.example.hibernatecrud_spring.repository.hibernate;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
import com.example.hibernatecrud_spring.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class HibernateUserRepositoryImpl implements UserRepository {
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
    public User find(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createQuery("from User as U left join fetch U.events where U.id = :id");

            return (User) query.setParameter("id",id).getSingleResult();
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            //Query query = session.createQuery("from User as U left join fetch U.events,Event as E left join fetch E.user left join fetch " +
             //       "E.file where U.id = E.id");
            Query query = session.createQuery("from User as U left join fetch U.events");
            return query.getResultList();
        }
    }


    @Override
    public void delete(Integer id) {
        try (Session session = HibernateUtils.getSession()){
            session.getTransaction().begin();
            Query query = session.createQuery("delete User as U where U.id =:id");
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
        }

    }
}
