package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(target="userId", source="userDao.id")
    User userDaoToUserDto(UserDAO userDao);
    @Mapping(target="id", source="userDto.userId")
    UserDAO userDtoToUserDao(User userDto);
}
