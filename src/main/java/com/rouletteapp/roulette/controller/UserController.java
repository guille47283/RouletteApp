package com.rouletteapp.roulette.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rouletteapp.roulette.DTO.UserDTO;
import com.rouletteapp.roulette.model.User;
import com.rouletteapp.roulette.service.UserService;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController  // No va @AutoController ????
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;



    @PostMapping("/users")
    public ResponseEntity<User> saveUser(  @RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.savedUser(user));
    }

    @Hidden
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
    public String deleteUserById(@PathVariable ("id") Long  id)  {

        if (userService.existById(id)){
            userService.deleteUser(id);
            return "ok"+ id + "deleted.";
        }
        else return " not found id: "+ id;
//        userService.deleteUser(id);
//        ResponseEntity.ok(!userService.existById(id));
//        return "ok";
    }
    @PutMapping("/users")
    public ResponseEntity<User> editUser (@RequestBody User user){
        return ResponseEntity.ok().body(userService.editUser(user));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long  id){

        Optional<UserDTO> userOptional = userService.findID(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }

    }


}
