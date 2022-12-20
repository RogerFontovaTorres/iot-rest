package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.*;
import iot.home.service.iotrest.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomesController implements HomesApi{

    @Autowired
    HomeService homeService;

    @Override
    public ResponseEntity<Void> deleteHomeById(String homeId) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(homeService.checkHomeAccess(userDao, Integer.valueOf(homeId))){
            homeService.deleteHome(Integer.valueOf(homeId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<Home> getHomeById(String homeId) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(homeService.checkHomeAccess(userDao, Integer.valueOf(homeId))){
            return new ResponseEntity<>(homeService.getHomeByIdAndUserId(Integer.valueOf(homeId), userDao.getId()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<List<Home>> getHomes(GetHomesRequest getHomesRequest) {
        // TODO
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Home> homes = homeService.getHomes(getHomesRequest, userDao.getId());
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postHomeById(String homeId, Home home) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(home.getOwnerId() != null && userDao.getId().equals(home.getOwnerId())){
            homeService.updateHome(home);
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> putHome(Home home) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(home.getOwnerId() != null && userDao.getId().equals(home.getOwnerId())){
            homeService.saveHome(home);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Home>> searchHomes(String searchAddress, String searchDescription) {
        return null;
    }
}
