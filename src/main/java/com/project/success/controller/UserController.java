package com.project.success.controller;

import com.project.success.application.UserService;
import com.project.success.model.User;
import com.project.success.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    @PostMapping(value="/login",
                 produces = "application/json")
    public User login(@RequestBody User userdata) {

        User user = userRepository.findByEmail(userdata.getEmail());

//        user.ifPresent(selectUser -> {
//            System.out.println("user : " + selectUser);
//            System.out.println("user : " + selectUser.getEmail());
//        });


        return user;

    }



    @GetMapping("/signup")
    public User signup(){

        User user = new User();

        user.setName("TestUser04");
        user.setAddress("cccccc");
        user.setEmail("admin4@admin.com");
        user.setPhone("010-111-1111");
        user.setPassword("1111");
        user.setSalt("2222");

        User newUser = userRepository.save(user);

        return newUser;
    }


    @PostMapping(value="/sign",
                 produces = "application/json")
    public User sign(@RequestBody User userdata){

        System.out.println(userdata);
        User user = new User();
        user.setEmail(userdata.getEmail());
        user.setName(userdata.getEmail());
        user.setPassword(userdata.getPassword());
        user.setAddress(userdata.getAddress());
        user.setPhone(userdata.getPhone());

        User newUser = userRepository.save(user);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

       return newUser;
    }




    // 밑으로 강의에서 본 코드
    @GetMapping("/users")
    public List<User> list() {
        List<User> users = userService.getUsers();
        return null;
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {

        System.out.println("resource : " + resource);
        String email = resource.getEmail();
        String name = resource.getName();
        String password = resource.getPassword();
        User user = userService.addUser(email, name, password);
        String url = "/users/" + user.getIdx();

        return ResponseEntity.created(new URI(url)).body("{}");
    }

    @PatchMapping("/user/{userId}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody User resource

    ) {

        String email = resource.getEmail();
        String name = resource.getName();
        userService.updateUser(id, email, name);
        return "{}";
    }

}
