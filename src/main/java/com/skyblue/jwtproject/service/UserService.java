package com.skyblue.jwtproject.service;

import com.skyblue.jwtproject.model.Users;
import com.skyblue.jwtproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    public String saveUsers(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User---saved";
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public String verify(Users user) {

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()
                ));



        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "an error has occured";
    }
}
