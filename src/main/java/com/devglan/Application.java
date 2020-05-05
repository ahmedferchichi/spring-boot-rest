package com.devglan;

import com.devglan.dao.UserDao;
import com.devglan.model.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner init(UserDao userDao){
        return args -> {

            User user1 = new User();
            user1.setFirstName("Devglan");
            user1.setLastName("Devglan");
            user1.setEmail("devglan@gmail.com");
            user1.setPassword("devglan");
            user1.setTypeUser("R");
            userDao.save(user1);

            User user2 = new User();
            user2.setFirstName("John");
            user2.setLastName("Doe");
            user2.setEmail("john@gmail.com");
            user2.setPassword("john");
            user2.setTypeUser("M");
            userDao.save(user2);
        };
    }

}
