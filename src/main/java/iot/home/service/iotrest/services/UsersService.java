package iot.home.service.iotrest.services;

import iot.home.service.iotrest.Mappers.UserMapper;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.PutUserRequest;
import iot.home.service.iotrest.dto.User;
import iot.home.service.iotrest.repositories.UsersRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public User getUserById(Integer id){
        Optional<UserDAO> userDao = usersRepository.findById(id);
        return userMapper.userDaoToUserDto(userDao.orElse(null));
    }

    public User getUserByName(String name){
        Optional<UserDAO> userDAO = usersRepository.findByName(name);
        return userMapper.userDaoToUserDto(userDAO.orElse(null));
    }
    public UserDAO getUserDaoByName(String name){
        Optional<UserDAO> userDAO = usersRepository.findByName(name);
        return userDAO.orElse(null);
    }

    public void updateUser(Integer id, PutUserRequest updateData){
        UserDAO userDao = usersRepository.findById(id).orElse(null);
        if(userDao != null){
            if(updateData.getName() != null){
                userDao.setName(updateData.getName());
            }
            if(updateData.getPassword() != null){
                userDao.setPassword(updateData.getPassword());
            }

        }

    }

    public void saveUser(User user){
        UserDAO existingUser = usersRepository.findByName(user.getName()).orElse(null);
        if(existingUser != null){
            throw new RuntimeException("User already exists!");
        }
        UserDAO userDao = userMapper.userDtoToUserDao(user);
        usersRepository.save(userDao);
    }


}
