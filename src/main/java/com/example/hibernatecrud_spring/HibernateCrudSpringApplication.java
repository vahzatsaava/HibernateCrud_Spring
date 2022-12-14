package com.example.hibernatecrud_spring;

import com.example.hibernatecrud_spring.model.Event;
import com.example.hibernatecrud_spring.model.File;
import com.example.hibernatecrud_spring.model.Role;
import com.example.hibernatecrud_spring.model.User;
import com.example.hibernatecrud_spring.repository.UserRepository;
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
        //userRepository.add(new User("@mail","sdfsdf","dfsdfs","sdfsdf", Role.USER));
        //fileRepository.add(new File("sdfsdf","www.ewe",Role.ADMIN));
        File file = new File("asdasdasdads","asdasdad",Role.ADMIN);
        User user = new User("@mailwerw","sdfsdf","dsfsdf","dsfsdf",Role.USER);

        System.out.println(hibernateEventRepository.find(2));
    }

}
