package com.cinzogoni.springsecuritycustomform.utilities;


import com.cinzogoni.springsecuritycustomform.entity.User;
import com.cinzogoni.springsecuritycustomform.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CheckPasswordEncoding {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public boolean checkPasswordEncoding(String username, String rawPassword) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }

        String encodedPassword = user.getPassword();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
