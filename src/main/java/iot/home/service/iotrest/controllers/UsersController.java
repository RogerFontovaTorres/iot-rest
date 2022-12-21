package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.PutUserRequest;
import iot.home.service.iotrest.dto.User;
import iot.home.service.iotrest.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController implements UsersApi {

    @Autowired
    UsersService usersService;

    @Override
    public ResponseEntity<User> getUserById(String userId) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userId.equals(Integer.toString(userDao.getId()))){
            User user = usersService.getUserById(Integer.valueOf(userId));
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    @Override
    public ResponseEntity<Void> postUserById(String userId, PutUserRequest putUserRequest) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userId.equals(Integer.toString(userDao.getId()))){
            usersService.updateUser(Integer.valueOf(userId), putUserRequest);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userId.equals(Integer.toString(userDao.getId()))){
            usersService.deleteUser(Integer.valueOf(userId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
