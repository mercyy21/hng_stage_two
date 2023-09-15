package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<CustomResponse> createUser(@RequestBody UserEntity userEntity){
        String userName= userEntity.getName();
        CustomResponse response = new CustomResponse();
        if(userName.matches("^[A-Za-z ]+$")){
            UserEntity savedUser = userService.createPerson(userEntity);
            response.setUserEntity(savedUser);
            return ResponseEntity.ok(response);
        }
        response.setMessage("Username cannot be an integer");
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }

    @GetMapping(path = "{identifier}")
    public ResponseEntity<UserEntity> getPersonByIdOrName(@PathVariable String identifier){
        UserEntity userEntity;
        if(identifier.matches("\\d+")){//matches 1 or more consecutive digits, d stands for digits(0-9)
            Long id = Long.parseLong(identifier);
             userEntity = userService.getPersonById(id);
            return ResponseEntity.ok(userEntity);
        }
        else {
            userEntity = userService.getPersonByName(identifier);
            return ResponseEntity.ok(userEntity);
        }
    }


    @PutMapping(path = "{identifier}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "identifier") String identifier, @RequestBody Map<String,Object> userEntity){
        UserEntity updatedUserEntity;
        if(identifier.matches("\\d+")){//matches 1 or more consecutive digits, d stands for digits(0-9)
            Long id = Long.parseLong(identifier);
            return userService.updatePersonById(id,userEntity);
        }
        else {
            return userService.updatePersonByName(identifier,userEntity);
        }
    }

    @DeleteMapping("{user_id}")

    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(value = "user_id")String identifier){
        UserEntity updatedUserEntity;
        if(identifier.matches("\\d+")){//matches 1 or more consecutive digits, d stands for digits(0-9)
            Long id = Long.parseLong(identifier);
            return userService.deletePersonById(id);
        }
        else {
            return userService.deletePersonByName(identifier);
        }

    }


}
