package com.project.success.application;

import com.project.success.model.User;
import com.project.success.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User addUser(String email, String name, String password) {

        User user = User.builder()
                .email(email)
                .name(name)
                .password(password)
                .build();

        return userRepository.save(user);
    }

    public User updateUser(Long id, String email, String name){

        User user = userRepository.findById(id).orElse(null);

        user.setEmail(email);
        user.setName(name);


        return user;
    }
}
