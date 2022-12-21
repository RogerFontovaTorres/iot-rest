package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T18:34:37+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDaoToUserDto(UserDAO userDao) {
        if ( userDao == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDao.getId() );
        user.setName( userDao.getName() );
        user.setPassword( userDao.getPassword() );

        return user;
    }

    @Override
    public UserDAO userDtoToUserDao(User userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserDAO userDAO = new UserDAO();

        userDAO.setId( userDto.getUserId() );
        userDAO.setName( userDto.getName() );
        userDAO.setPassword( userDto.getPassword() );

        return userDAO;
    }
}
