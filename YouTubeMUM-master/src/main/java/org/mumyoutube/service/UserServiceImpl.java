package org.mumyoutube.service;

import org.mumyoutube.data.UserRepository;
import org.mumyoutube.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl  implements UserService {


    private UserRepository repository;

    @Autowired
    UserServiceImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>)repository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return repository.findById(userId).get();
    }

    public User getUserByUserName(String userName) {   return repository.findByUserName(userName); }

    @Override
    public boolean addUser(User user) {
        try{
             repository.save(user);
             return  true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void updateUser( User user) {

         repository.save(user);
    }

    @Override
    public void deleteUser(long userId) {
        repository.deleteById(userId);

    }
}
