package org.mumyoutube.service;

import org.mumyoutube.data.UserRepository;
import org.mumyoutube.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MyUserDetailsService implements UserDetailsService {
    private static List<User> users = new ArrayList();
    private User usr = new User();

    @Autowired
    private UserService userService;

    public MyUserDetailsService(UserService usrServ) {
        this.userService = usrServ;
        //in a real application, instead of using local data,
        // we will find user details by some other means e.g. from an external system
        // users.add(new User("erin", "123", "ADMIN"));
        // users.add(new User("mike", "234", "ADMIN"));
        //users.add(new User)
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //handle exception
        usr = userService.getUserByUserName(username);
        users.add(usr);

        if (!usr.getUserName().equals(username)) {
            throw new UsernameNotFoundException("User not found for user: " + username);
        }
        return toUserDetails(usr);
    }

    private UserDetails toUserDetails(User userObject) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return org.springframework.security.core.userdetails.User.withUsername(userObject.getUserName())
                .password(encoder.encode(userObject.getPassword()))
                .roles(userObject.getRole()).build();
    }
}