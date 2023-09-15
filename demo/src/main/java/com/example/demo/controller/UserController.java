package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        String userName= userEntity.getName();
        if(userName.getClass()!=String.class){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserEntity savedUser = userService.createPerson(userEntity);
    return ResponseEntity.ok(savedUser);
    }

    @GetMapping(path = '{slug}')
    public ResponseEntity<UserEntity> findPersonByIdOrName(@PathVariable String slug)
    if(slug instanceof Integer){
        Long id = Long.parseLong(slug)
        UserEntity userEntity = userService.getPersonById(slug).orElse(null)
        return ResponseEntity.ok(userEntity)
    }
    else {
        return ResponseEntity.ok(userService.getPersonByName(slug))
    }

    @GetMapping(path = "{user_id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable(value = "user_id") Long userId){
    UserEntity userEntity =userService.getPersonById(userId);
    if(userEntity==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(userEntity);
    }
   /* @GetMapping(path = "{name}")
    public ResponseEntity<UserEntity> getUserByName(@PathVariable(value = "name") String name){
        UserEntity userEntity =userService.getPersonByName(name);
        if(userEntity==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userEntity);
    }*/

    @PutMapping(path = "{user_id}")
    public ResponseEntity<UserEntity> updateUserById(@PathVariable(value = "user_id") Long userId, @RequestBody Map<String,Object> userEntity){
    return userService.updatePersonById(userId,userEntity);
    }

    @DeleteMapping("{user_id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable(value = "user_id")Long userId){
    return userService.deletePersonById(userId);

    }


}
