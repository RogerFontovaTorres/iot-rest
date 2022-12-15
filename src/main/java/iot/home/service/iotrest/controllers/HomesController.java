package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.entities.Home;
import iot.home.service.iotrest.entities.PutHomeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomesController implements HomesApi{
    @Override
    public ResponseEntity<Void> deleteHomeById(String homeId) {
        return null;
    }

    @Override
    public ResponseEntity<Home> getHomeById(String homeId) {
        Home home = new Home();
        home.setHomeId(1);
        home.address("lleida");
        home.description("casa lila");
        return new ResponseEntity<>(home, HttpStatus.OK);
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
