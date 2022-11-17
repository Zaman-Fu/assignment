package bootcamp.assignment.controller;

import bootcamp.assignment.entity.User;
import bootcamp.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v3/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
