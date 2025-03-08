package org.example.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userservice.model.UserDto;
import org.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserDto user) {
        userService.registerUser(user);
    }

    @GetMapping("/get/{id}")
    public UserDto getUserByTelegramId(@PathVariable int id) {
        return userService.getUserByTelegramId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
