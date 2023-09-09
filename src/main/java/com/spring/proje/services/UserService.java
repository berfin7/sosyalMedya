package com.spring.proje.services;
import com.spring.proje.entities.User;
import com.spring.proje.repos.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }


    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public User getOneUser(Long userId) {
        return userRepository.getById(userId);
    }


    public User updateOneUser(Long userId, User newUser) {
     Optional <User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
             userRepository.save(foundUser);
            return foundUser;
        } else

            return null;
    }

    public void deleteOneUser(Long user_id) {

            userRepository.deleteById(user_id);
    }
}
