package iot.home.service.iotrest.services;

import iot.home.service.iotrest.Mappers.HomeMapper;
import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.repositories.HomeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    private HomeMapper homeMapper = Mappers.getMapper(HomeMapper.class);

    public boolean checkHomeAccess(UserDAO user, Integer homeId){
        return homeRepository.findHomeDAOByIdAndOwnerId(user.getId(), homeId) != null;
    }

    public Home getHomeById(Integer id){
        HomeDAO homeDAO = homeRepository.findById(id).orElse(null);
        return homeMapper.homeDaoToHomeDto(homeDAO);
    }

}
