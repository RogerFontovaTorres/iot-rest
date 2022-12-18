package iot.home.service.iotrest.repositories;


import iot.home.service.iotrest.dao.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserDAO, Integer> {
    UserDAO getById(Integer id);
    Optional<UserDAO> findByName(String name);
    UserDAO getUserDAOById(Integer id);
}
