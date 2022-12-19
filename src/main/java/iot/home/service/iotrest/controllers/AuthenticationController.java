package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.config.JwtUtils;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.User;
import iot.home.service.iotrest.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
