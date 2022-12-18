package iot.home.service.iotrest.repositories;

import iot.home.service.iotrest.dao.HomeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<HomeDAO, Integer> {
    HomeDAO findHomeDAOByIdAndOwnerId(Integer id, Integer ownerId);
}
