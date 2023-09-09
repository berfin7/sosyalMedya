package com.spring.proje.controllers;
import com.spring.proje.entities.User;
import com.spring.proje.services.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping //users
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/{user_id}")
    public User getOneUser(@PathVariable Long user_id) {
        return userService.getOneUser(user_id);

    }


    @PutMapping("/{user_id}")
    public User updateOneUser(@PathVariable Long user_id, @RequestBody User newUser) {
        return userService.updateOneUser(user_id,newUser);

    }

    @DeleteMapping("/{user_id}")
    public void deleteOneUser(@Validated Long user_id){
        userService.deleteOneUser(user_id);

    }

}













