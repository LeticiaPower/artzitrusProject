package com.leticia.zitrus.artzitrus.application;

import com.leticia.zitrus.artzitrus.model.User;
import com.leticia.zitrus.artzitrus.model.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Test
    public void returnSpringUserFromUserName() {
        User user = new User("userName", "pass");
        org.springframework.security.core.userdetails.User expectedUser =
                new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new HashSet<>());
        when(repository.findByName("userName")).thenReturn(Optional.of(user));

        UserDetails resultUser = userService.loadUserByUsername("userName");

        assertThat(resultUser, equalTo(expectedUser));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void throwExceptionBecauseUserNotFound() {
        when(repository.findByName("noName")).thenThrow(UsernameNotFoundException.class);
        userService.loadUserByUsername("noName");
    }

    @Autowired
    private UserDetailsService userService;

    @MockBean
    private UserRepository repository;

    @TestConfiguration
    static class UserDetailsServiceTestContextConfiguration {

        @Bean
        public UserDetailsService userService() {
            return new UserService();
        }
    }



}
