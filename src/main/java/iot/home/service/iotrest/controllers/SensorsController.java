package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.dto.PutSensorRequest;
import iot.home.service.iotrest.dto.Sensor;
import iot.home.service.iotrest.dto.User;
import iot.home.service.iotrest.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class SensorsController implements SensorsApi {
    @Autowired
    SensorService sensorsService;
    @Override
    public ResponseEntity<Void> deleteSensorById(Integer sensorId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Sensor>> getSensorsByHomeId(Integer homeId) {

        UserDAO sensorDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDAO homeDao = (UserDAO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(sensorDao.equals(homeDao)){
            List<Sensor> sensors = sensorsService.getSensorByHomeId(homeId);
            return new ResponseEntity<>(sensors, HttpStatus.OK);
        }
        else return null;
    }

    @Override
    public ResponseEntity<Void> putSensor(PutSensorRequest putSensorRequest) {
        return null;
    }
}
