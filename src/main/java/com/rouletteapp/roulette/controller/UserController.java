package com.rouletteapp.roulette.controller;

import com.rouletteapp.roulette.model.User;
import com.rouletteapp.roulette.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController  // No va @AutoController ????
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("/users")
    public ResponseEntity<User> saveUser( @RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.savedUser(user));
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers (
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10")Integer size,
            @RequestParam(required = false, defaultValue = "false")Boolean enablePagination ){
        return ResponseEntity.ok(userService.getAllUsers(page,size,enablePagination));

    }
    @GetMapping("/traerUs")
    public ResponseEntity <List<User>> traerUs(){
        return ResponseEntity.ok(userService.getAllUsers2());
    }
    @DeleteMapping(value= "/{id}")
    public String deleteUserById(@PathVariable ("id") Integer id)  {
        userService.deleteUser(id);
        ResponseEntity.ok(!userService.existById(id));
        return "ok";
    }
    @PutMapping("/users")
    public ResponseEntity<User> editUser (@RequestBody User user){
        return ResponseEntity.ok().body(userService.editUser(user));
    }


}
