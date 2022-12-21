package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.dto.PutHomeRequest;
import iot.home.service.iotrest.repositories.HomeRepository;
import iot.home.service.iotrest.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomesController implements HomesApi{

    @Autowired
    HomeService homeService;

    @Autowired
    HomeRepository homeRepository;

    public boolean checkHomeAccess(UserDAO user, Integer homeId){
        return homeRepository.findHomeDAOByIdAndOwnerId(user.getId(), homeId) != null;
    }

    @Override
    public ResponseEntity<Void> deleteHomeById(String homeId) {
        return null;
    }

    @Override
    public ResponseEntity<Home> getHomeById(String homeId) {
        return new ResponseEntity<>(homeService.getHomeById(Integer.valueOf(homeId)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Home>> getHomes() {
        return null;
    }

    @Override
    public ResponseEntity<Void> postHomeById(String homeId, PutHomeRequest putHomeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> putHome(PutHomeRequest putHomeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<Home>> searchHomes(String searchAddress, String searchDescription) {
        return null;
    }
}
