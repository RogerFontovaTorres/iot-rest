package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dto.PutUserRequest;
import iot.home.service.iotrest.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import iot.home.service.iotrest.dto.User;

@Controller
public class UsersController implements UsersApi {

    @Autowired
    UsersService usersService;

    @Override
    public ResponseEntity<User> getUserById(String userId) {
//        Integer id = Integer.valueOf(userId);
//        User user = usersService.getUserById(id);

//        User user = new User();
//        user.setUserId(1);
//        user.setName("Jo");
//        user.setPassword("pass");

        User user = usersService.getUserByName("Marc");


        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Void> postUserById(String userId, PutUserRequest putUserRequest) {
        usersService.updateUser(Integer.valueOf(userId), putUserRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> putUser(PutUserRequest putUserRequest) {
        User user = new User();
        user.setName(putUserRequest.getName());
        user.setPassword(putUserRequest.getPassword());

        usersService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUserById(String userId) {
        return null;
    }
}
