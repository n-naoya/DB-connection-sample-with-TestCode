package com.example.server;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api")
public class UserController {

    private UserRepository userRepo;

    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("users")
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @GetMapping("users/{id}")
    public User get(@PathVariable("id") String id) {
        return userRepo.get(id);
    }
}
