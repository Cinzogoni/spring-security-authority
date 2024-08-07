package com.cinzogoni.springsecuritycustomform;

import com.cinzogoni.springsecuritycustomform.entity.Authority;
import com.cinzogoni.springsecuritycustomform.entity.User;
import com.cinzogoni.springsecuritycustomform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityAuthorityApplication implements CommandLineRunner {


    private final UserRepository userRepository;
    @Autowired
    public SpringSecurityAuthorityApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityAuthorityApplication.class, args);

    }

    @Override
    public void run(String... args) {

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String rawPassword = "357159456";
//        String encodedPassword = encoder.encode(rawPassword);
//
//        User user = new User();
//        user.setUsername("employeeAn");
//        user.setPassword(encodedPassword);
//        user.setEnabled(true);
//
//        Authority authority = new Authority();
//        authority.setAuthority("EMPLOYEE");
//        user.addAuthority(authority);
//
//        userRepository.save(user);
    }
}
