package iot.home.service.iotrest.repositories;

import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<List<SensorDAO>, Integer> {
    List<SensorDAO> findSensorDAOByHomeId(Integer homeId);
}
