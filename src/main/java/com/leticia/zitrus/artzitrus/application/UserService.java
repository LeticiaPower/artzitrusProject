package com.leticia.zitrus.artzitrus.application;

import com.leticia.zitrus.artzitrus.model.User;
import com.leticia.zitrus.artzitrus.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
            User user = repository.findByName(name).get();

            org.springframework.security.core.userdetails.User userSpring =
                    new org.springframework.security.core.userdetails.User
                            (user.getName(), user.getPassword(), new HashSet<>());

            return userSpring;
    }
}
