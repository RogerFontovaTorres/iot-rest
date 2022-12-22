package iot.home.service.iotrest.controllers;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.*;
import iot.home.service.iotrest.services.HomeService;
import iot.home.service.iotrest.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorsController implements SensorsApi {
    @Autowired
    SensorService sensorsService;

    @Autowired
    private HomeService homeService;



    @Override
    public ResponseEntity<Void> deleteSensorById(String sensorId) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(sensorsService.checkSensorAccess(userDao, sensorId)){
            sensorsService.deleteSensor(sensorId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<Sensor>> getSensorsByHomeId(Integer homeId) {

        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(homeService.checkHomeAccess(userDao, homeId)) {
            return new ResponseEntity<>(sensorsService.getSensorByHomeId(homeId), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<List<SensorPrediction>> getSensorsById(String sensorId) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(sensorsService.checkSensorAccess(userDao, sensorId)) {
            return new ResponseEntity<>(sensorsService.getSensorById(sensorId), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<PostPutReturn> putSensor(Sensor sensor) {
        UserDAO userDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PostPutReturn answer = new PostPutReturn();
        if(!sensorsService.checkSensorAccess(userDao, sensor.getSensorId())){
            sensorsService.saveSensor(sensor, userDao);
            answer.setUrl("/sensors/" + sensor.getSensorId());
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }else{
            answer.setUrl("Sensor already exists, use POST instead: /sensors");
        }
        return new ResponseEntity<>(answer, HttpStatus.FORBIDDEN);
    }



//    @Override
//    public ResponseEntity<Void> putSensor(PutSensorRequest putSensorRequest) {
//    }
}