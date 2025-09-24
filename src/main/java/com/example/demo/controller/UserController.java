package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}/password")
    public User updatePassword(@PathVariable Long id, @RequestParam String newPassword) {
        return userService.updatePassword(id, newPassword);
    }

    @PutMapping("/{id}/2fa")
    public User enableTwoFactor(@PathVariable Long id, @RequestParam boolean enabled) {
        return userService.enableTwoFactor(id, enabled);
    }
}
