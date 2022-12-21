package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.config.JwtUtils;
import iot.home.service.iotrest.dto.PutUserRequest;
import iot.home.service.iotrest.dto.User;
import iot.home.service.iotrest.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    AuthenticationManager authenticationManager;
    UsersService usersService;
    JwtUtils jwtUtils;

    public AuthenticationController(AuthenticationManager authenticationManager, UsersService usersService, JwtUtils jwtUtils){
        this.authenticationManager = authenticationManager;
        this.usersService = usersService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestBody User userRequest) {
        final UserDetails user = usersService.getUserDaoByName(userRequest.getName());
        if(user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("bad request");
    }
    @PutMapping("/sing-up")
    public ResponseEntity<Void> putUser(@RequestBody PutUserRequest putUserRequest) {
        User user = new User();
        user.setName(putUserRequest.getName());
        user.setPassword(putUserRequest.getPassword());

        usersService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
