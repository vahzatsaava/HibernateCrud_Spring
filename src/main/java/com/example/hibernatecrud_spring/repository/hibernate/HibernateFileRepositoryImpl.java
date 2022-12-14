package com.example.hibernatecrud_spring.repository.hibernate;

import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.repository.FileRepository;
import com.example.hibernatecrud_spring.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HibernateFileRepositoryImpl implements FileRepository {
    @Override
    public File add(File file) {
        try (Session session = HibernateUtils.getSession()) {
            session.save(file);
            return file;
        }
    }

    @Override
    public File update(File file) {
        try (Session session = HibernateUtils.getSession()) {
            session.getTransaction().begin();
            session.merge(file);
            session.getTransaction().commit();
        }
        return file;
    }

    @Override
    public File find(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(File.class, id);
        }

    }

    @Override
    public List<File> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            Query query = session.createQuery("from File ");
            return query.getResultList();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            session.getTransaction().begin();
            Query query = session.createQuery("delete File as F where F.id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }
}
