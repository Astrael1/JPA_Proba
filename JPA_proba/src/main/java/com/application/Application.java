package com.application;

import com.application.repositiory.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = BookRepository.class)
public class Application
{
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }
}
