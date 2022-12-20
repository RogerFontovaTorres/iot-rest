package iot.home.service.iotrest.services;

import iot.home.service.iotrest.Mappers.SensorMapper;
import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.Sensor;

import iot.home.service.iotrest.repositories.SensorRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    private SensorMapper sensorMapper = Mappers.getMapper(SensorMapper.class);

    public List<Sensor> getSensorByHomeId(Integer homeId){
        List<SensorDAO> sensorDao = sensorRepository.findSensorDAOByHomeId(homeId);
        List<Sensor> sensorDto = new ArrayList<Sensor>();
        for (SensorDAO sensor : sensorDao){
            sensorDto.add(sensorMapper.sensorDaoToSensorDto(sensor));
        }
        return sensorDto;
    }
}
