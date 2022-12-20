package iot.home.service.iotrest.repositories;

import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.SensorDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorsRepository extends JpaRepository<SensorDAO, Integer> {
    HomeDAO findSensorDAOByHomeIdAndRoom(Integer homeId, String room);
}
