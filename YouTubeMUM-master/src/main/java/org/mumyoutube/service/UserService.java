package org.mumyoutube.service;

import org.mumyoutube.data.UserRepository;
import org.mumyoutube.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(long userId);

    void deleteUser(long userId);
    void updateUser( User user);
    boolean addUser(User user);
    User getUserByUserName(String userName);
}
