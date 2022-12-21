package iot.home.service.iotrest.repositories;

import iot.home.service.iotrest.dao.SensorDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SensorRepository extends JpaRepository<SensorDAO, Integer> {

    Optional<SensorDAO> findSensorDAOById(String id);
    List<SensorDAO> findSensorDAOByHomeId(Integer homeId);


    @Query(value = "SELECT s.* FROM Sensors s, Homes h WHERE s.id = ?1 AND s.homeId = h.id AND h.ownerId = ?2", nativeQuery = true)
    SensorDAO findSensorDAOByIdAndOwnerId(String id, Integer ownerId);
}
