package com.example.hibernatecrud_spring.repository.hibernate;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.repository.EventRepository;
import com.example.hibernatecrud_spring.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HibernateEventRepositoryImpl implements EventRepository {
    @Override
    public Event add(Event event) {
        try (Session session = HibernateUtils.getSession()){
            session.save(event);
            return event;
        }
    }

    @Override
    public Event update(Event event) {
        try (Session session = HibernateUtils.getSession()){
            session.getTransaction().begin();
            session.merge(event);
            session.getTransaction().commit();
            return event;
        }
    }

    @Override
    public Event find(Integer id) {
        try (Session session = HibernateUtils.getSession()){
            Query query = session.createQuery("from Event  as E left join fetch E.file left join fetch E.user where E.id = :id");
            query.setParameter("id",id);
            return (Event) query.getSingleResult();
        }
    }

    @Override
    public List<Event> getAll() {
        try (Session session = HibernateUtils.getSession()){
            Query query = session.createQuery("from Event as E left join fetch E.user left join fetch E.file");
            return query.getResultList();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            session.getTransaction().begin();
            javax.persistence.Query query = session.createQuery("delete Event as U where U.id = :id");
            query.setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
