package com.example.hibernatecrud_spring.utils;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateUtils {
    private static SessionFactory factory;

    private HibernateUtils() {

    }

    private static SessionFactory getFactory() {
        if (factory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                    configuration.addAnnotatedClass(User.class);
                    configuration.addAnnotatedClass(Event.class);
                    configuration.addAnnotatedClass(File.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                factory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                log.error("Exception with session " + e);
            }
        }
        return factory;
    }

    public static Session getSession() {
        return getFactory().openSession();
    }
}
