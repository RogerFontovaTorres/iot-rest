package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.*;
import iot.home.service.iotrest.services.HomeService;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    public ResponseEntity<List<Home>> getHomes(String textSearch, String searchColumn) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Home> homes = homeService.getHomes(textSearch, searchColumn, userDao.getId());
        return new ResponseEntity<>(homes, HttpStatus.OK);    }

    @Override
    public ResponseEntity<Void> postHomeById(String homeId, PostHomeByIdRequest postHomeByIdRequest) {
        homeService.updateHome(Integer.valueOf(homeId), postHomeByIdRequest.id(Integer.valueOf(homeId)));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Void> putHome(PutHomeRequest homeRequest) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        homeService.saveHome(homeRequest, userDao.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
