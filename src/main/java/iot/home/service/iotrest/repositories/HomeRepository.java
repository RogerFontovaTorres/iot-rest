package iot.home.service.iotrest.repositories;

import iot.home.service.iotrest.dao.HomeDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<HomeDAO, Integer> {
    HomeDAO findHomeDAOByIdAndOwnerId(Integer id, Integer ownerId);
    List<HomeDAO> findHomeDAOByOwnerId(Integer ownerId);

    List<HomeDAO> findHomeDAOByOwnerIdAndDescriptionContaining(Integer ownerId, String description);
    List<HomeDAO> findHomeDAOByOwnerIdAndAddressContaining(Integer ownerId, String address);
}
