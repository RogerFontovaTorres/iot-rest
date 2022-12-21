package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dto.Home;
import iot.home.service.iotrest.dto.PutHomeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HomeMapper {
    HomeMapper INSTANCE = Mappers.getMapper(HomeMapper.class);
    @Mapping(target="homeId", source="homeDao.id")
    Home homeDaoToHomeDto(HomeDAO homeDao);
    @Mapping(target="id", source="homeDto.homeId")
    HomeDAO homeDtoToHomeDao(Home homeDto);

    HomeDAO putHomeRequestToHomeDao(PutHomeRequest homeDao);
}
