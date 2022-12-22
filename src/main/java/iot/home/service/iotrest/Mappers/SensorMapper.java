package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.PutSensorRequest;
import iot.home.service.iotrest.dto.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorMapper {
    SensorMapper INSTANCE = Mappers.getMapper(SensorMapper.class);
    @Mapping(target="sensorId", source="sensorDao.id")
    Sensor sensorDaoToSensorDto(SensorDAO sensorDao);
    @Mapping(target="id", source="sensorDto.sensorId")
    SensorDAO sensorDtoToSensorDao(Sensor sensorDto);

    SensorDAO putSensorRequestToSensorDao(PutSensorRequest sensorRequest);
}


