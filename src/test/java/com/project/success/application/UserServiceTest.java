package com.project.success.application;

import com.project.success.SuccessApplicationTests;
import com.project.success.model.User;
import com.project.success.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceTest extends SuccessApplicationTests {

    @Autowired
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }


    @Test
    public void addUser() {
        String email = "admin@admin.com";
        String name = "Admin";
        String password = "1234";

        User mockUser = User.builder().email(email).name(name).build();

        given(userRepository.save(any())).willReturn(mockUser);
        User user = userService.addUser(email, name, password);

        assertThat(user.getName(), is(name));
    }

    @Test
    public void updateUser() {
        Long id = 11L;
        String email = "admin@admin.com";
        String name = "Admin";

        User user = userService.updateUser(id, email, name);

        verify(userRepository).findById(eq(id));

        assertThat(user.getName(), is("Admin"));
    }

}