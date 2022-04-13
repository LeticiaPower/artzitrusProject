package com.leticia.zitrus.artzitrus;

import com.leticia.zitrus.artzitrus.model.User;
import com.leticia.zitrus.artzitrus.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class DefaultData implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String USERNAME = "zitrino";

    @Override
    public void run(String... args) throws Exception {
       Optional<User> user = userRepository.findByName(USERNAME);
       if (!user.isPresent()) {
           userRepository.save(new User(USERNAME, passwordEncoder.encode("venhaserfeliz")));
       }

    }
}
