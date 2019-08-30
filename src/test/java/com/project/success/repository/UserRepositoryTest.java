package com.project.success.repository;

import com.project.success.SuccessApplicationTests;
import com.project.success.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserRepositoryTest extends SuccessApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {

        User user = new User();

        user.setName("TestUser03");
        user.setAddress("bbbb");
        user.setEmail("admin3@admin.com");
        user.setPhone("010-111-1111");
        user.setPassword("1111");
        user.setSalt("2222");

        User newUser = userRepository.save(user);
        System.out.println("newUser :" + user );

    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("user : " + selectUser.getEmail());
        });
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(1L); //  id를 찾아보고 있는 id면 수정이 된다.

        user.ifPresent(selectUser -> {
            selectUser.setName("ppp");
            selectUser.setUpdatedAt(LocalDateTime.now());

            userRepository.save(selectUser);

        });
    }

    @Test
    @Transactional // test코드는 진행되지만 DB는 롤백을 해준다.
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        if(deleteUser.isPresent()){
            System.out.println( "데이터 존재 : " +deleteUser.get() );
        }else{
            System.out.println("데이터 삭제, 데이터 없음");
        };
    }


}