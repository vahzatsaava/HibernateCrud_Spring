package com.example.hibernatecrud_spring;

import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.hibernate.HibernateEventRepositoryImpl;
import com.example.hibernatecrud_spring.repository.hibernate.HibernateFileRepositoryImpl;
import com.example.hibernatecrud_spring.repository.hibernate.HibernateUserRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateCrudSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudSpringApplication.class, args);

        HibernateUserRepositoryImpl userRepository = new HibernateUserRepositoryImpl();
        HibernateFileRepositoryImpl fileRepository = new HibernateFileRepositoryImpl();
        HibernateEventRepositoryImpl hibernateEventRepository = new HibernateEventRepositoryImpl();
        /*
        spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.format_sql=true
         */
    }


}
