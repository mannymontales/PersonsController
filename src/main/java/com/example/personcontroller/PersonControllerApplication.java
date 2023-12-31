package com.example.personcontroller;


import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonControllerApplication.class, args);
    }

//    @Bean
//    ServletRegistrationBean h2servletRegistration(){
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }

    /*
    A bean is simply a Java object that is created, assembled, and managed by the Spring container.
    It's an instance of a class that is instantiated and maintained by Spring.
     */

}
