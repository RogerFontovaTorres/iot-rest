package iot.home.service.iotrest.services;

import iot.home.service.iotrest.Mappers.HomeMapper;
import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.dto.PostHomeByIdRequest;
import iot.home.service.iotrest.dto.PutHomeRequest;
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
        return homeRepository.findHomeDAOByIdAndOwnerId(homeId, user.getId()) != null;
    }

    public List<Home> getHomes(String textSearch, String searchColumn, Integer ownerId){
        List<HomeDAO> home;
        System.out.println("here "+searchColumn+".");
        if(searchColumn != null && textSearch != null){
            switch(searchColumn){
                case "address":
                    home = homeRepository.findHomeDAOByOwnerIdAndAddress(ownerId, textSearch);
                    break;
                case "description":
                    home = homeRepository.findHomeDAOByOwnerIdAndDescription(ownerId, textSearch);
                    break;
                default:
                    return new ArrayList<>();
            }
            List<Home> returnHomes = new ArrayList<>();
            for(HomeDAO homeDao : home){
                returnHomes.add(homeMapper.homeDaoToHomeDto(homeDao));
            }
            return returnHomes;
        }else {
            System.out.println("noo");
            List<Home> returnHomes = new ArrayList<>();
            for(HomeDAO homeDao : homeRepository.findHomeDAOByOwnerId(ownerId)){
                returnHomes.add(homeMapper.homeDaoToHomeDto(homeDao));
            }
            return returnHomes;
        }
    }

    public Home getHomeByIdAndUserId(Integer homeId, Integer ownerId){
        HomeDAO homeDAO = homeRepository.findHomeDAOByIdAndOwnerId(homeId, ownerId);
        return homeMapper.homeDaoToHomeDto(homeDAO);
    }

    public Home saveHome(PutHomeRequest homeRequest, Integer ownerId){
        HomeDAO home = homeMapper.putHomeRequestToHomeDao(homeRequest);
        home.setOwnerId(ownerId);
        return homeMapper.homeDaoToHomeDto(homeRepository.save(home));

    }

    public void updateHome(Integer id, PostHomeByIdRequest home){

        HomeDAO homeDao = homeRepository.findById(id).orElse(null);
        if(homeDao != null){
            if(home.getName() != null){
                homeDao.setName(home.getName());
            }
            if(home.getAddress() != null){
                homeDao.setAddress(home.getAddress());
            }
            if(home.getDescription() != null){
                homeDao.setDescription((home.getDescription()));
            }
            homeRepository.save(homeDao);
        }
    }
    public void deleteHome(Integer homeId){
        homeRepository.findById(homeId).ifPresent(home -> homeRepository.delete(home));
    }
}
