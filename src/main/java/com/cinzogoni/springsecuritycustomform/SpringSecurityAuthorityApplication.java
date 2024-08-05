package com.cinzogoni.springsecuritycustomform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityAuthorityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthorityApplication.class, args);

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "321654987";
//        String encodedPassword = encoder.encode(rawPassword);
//        System.out.println("Encoded password: " + encodedPassword);

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "123456789"; // Mật khẩu đầu vào
//        String encodedPassword = "$2a$10$c9GJ5p8vu8aMUGQcfbBniOFJiu4KKWMqgPTOLccgaeo2iU3oMW7Zu";
//
//        boolean matches = encoder.matches(rawPassword, encodedPassword);
//        System.out.println("Password matches: " + matches);
    }
}
