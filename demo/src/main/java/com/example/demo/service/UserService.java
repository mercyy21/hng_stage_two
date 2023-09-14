package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create new person
    public UserEntity createPerson(UserEntity userEntity){
    UserEntity savedUserEntity = userRepository.save(userEntity);
    return savedUserEntity;
    }

    //Get person by ID
    public UserEntity getPersonById(Long userId){
    UserEntity userEntity = userRepository.findById(userId).get();
    return userEntity;
    }
    //Get person by name
    public UserEntity getPersonByName(String name){
        UserEntity userEntity = userRepository.findByName(name);
        return userEntity;
    }

    //Update person by ID
    public ResponseEntity<UserEntity> updatePersonById(Long userId, Map<String,Object> userEntity){
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);//Used optional for null safety purposes

        if(!optionalUserEntity.isPresent()){
            return ResponseEntity.notFound().build();
        }
        UserEntity existingUserEntity = optionalUserEntity.get();
        for (Map.Entry<String, Object> entry : userEntity.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            // Update fields based on the keys provided in the request
            switch (key) {
                case "name":
                    existingUserEntity.setName((String) value);
                    break;
                // Add cases for other fields you want to support
            }
        }
        // Passed the new values into the already existing tutorial thereby updating it
        final UserEntity updatedUser = userRepository.save(existingUserEntity);
        return ResponseEntity.ok(updatedUser);
    }

    //delete user by id
    public ResponseEntity<HttpStatus> deletePersonById(Long userId){
        UserEntity userToDelete = userRepository.findById(userId).orElse(null);
        if(userToDelete==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(userToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
