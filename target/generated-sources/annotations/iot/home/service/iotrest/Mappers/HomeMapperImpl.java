package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dto.Home;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T13:28:21+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class HomeMapperImpl implements HomeMapper {

    @Override
    public Home homeDaoToHomeDto(HomeDAO homeDao) {
        if ( homeDao == null ) {
            return null;
        }

        Home home = new Home();

        home.setHomeId( homeDao.getId() );
        home.setOwnerId( homeDao.getOwnerId() );
        home.setName( homeDao.getName() );
        home.setAddress( homeDao.getAddress() );
        home.setDescription( homeDao.getDescription() );

        return home;
    }

    @Override
    public HomeDAO homeDtoToHomeDao(Home homeDto) {
        if ( homeDto == null ) {
            return null;
        }

        HomeDAO homeDAO = new HomeDAO();

        homeDAO.setId( homeDto.getHomeId() );
        homeDAO.setOwnerId( homeDto.getOwnerId() );
        homeDAO.setName( homeDto.getName() );
        homeDAO.setAddress( homeDto.getAddress() );
        homeDAO.setDescription( homeDto.getDescription() );

        return homeDAO;
    }
}
