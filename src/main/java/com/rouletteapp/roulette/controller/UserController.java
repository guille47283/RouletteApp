package com.rouletteapp.roulette.controller;

import com.rouletteapp.roulette.model.User;
import com.rouletteapp.roulette.repository.IUserRepository;
import com.rouletteapp.roulette.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.savedUser(user));
    }

}
