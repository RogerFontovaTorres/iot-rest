package iot.home.service.iotrest.services;

import iot.home.service.iotrest.Mappers.HomeMapper;
import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.GetHomesRequest;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.repositories.HomeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    private final HomeMapper homeMapper = Mappers.getMapper(HomeMapper.class);

    public boolean checkHomeAccess(UserDAO user, Integer homeId){
        return homeRepository.findHomeDAOByIdAndOwnerId(user.getId(), homeId) != null;
    }

    public List<Home> getHomes(GetHomesRequest getHomesRequest, Integer ownerId){
        // TODO
        List<HomeDAO> home;
        switch(getHomesRequest.getSearchColumn()){
            case ADDRESS:
                home = homeRepository.findHomeDAOByOwnerIdAndAddress(ownerId, getHomesRequest.getTextSearch());
                break;
            case DESCRIPTION:
                home = homeRepository.findHomeDAOByOwnerIdAndDescription(ownerId, getHomesRequest.getTextSearch());
                break;
            default:
                home = new ArrayList<>();
        }
        List<Home> returnHomes = new ArrayList<>();
        for(HomeDAO homeDao : home){
            returnHomes.add(homeMapper.homeDaoToHomeDto(homeDao));
        }
        return returnHomes;
    }

    public Home getHomeByIdAndUserId(Integer homeId, Integer ownerId){
        HomeDAO homeDAO = homeRepository.findHomeDAOByIdAndOwnerId(homeId, ownerId);
        return homeMapper.homeDaoToHomeDto(homeDAO);
    }

    public Home saveHome(Home home){
        HomeDAO homeDao = homeMapper.homeDtoToHomeDao(home);
        return homeMapper.homeDaoToHomeDto(homeRepository.save(homeDao));
    }

    public Home updateHome(Home home){
        HomeDAO homeDao = homeMapper.homeDtoToHomeDao(home);
        return homeMapper.homeDaoToHomeDto(homeRepository.save(homeDao));
    }
    public void deleteHome(Integer homeId){
        homeRepository.findById(homeId).ifPresent(home -> homeRepository.delete(home));
    }
}
