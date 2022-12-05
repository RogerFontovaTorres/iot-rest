package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.entities.PutUserRequest;
import iot.home.service.iotrest.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements UsersApi {
    @Override
    public ResponseEntity<User> getUserById(String userId) {
        User user = new User();
        user.setUserId(1);
        user.setName("Roger");
        user.setPassword("MyPassword");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postUserById(String userId, PutUserRequest putUserRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> putUser(PutUserRequest putUserRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        return null;
    }
}
