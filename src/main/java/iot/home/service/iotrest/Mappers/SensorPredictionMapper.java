package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.PutSensorRequest;
import iot.home.service.iotrest.dto.Sensor;
import iot.home.service.iotrest.dto.SensorPrediction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SensorPredictionMapper {
    SensorPredictionMapper INSTANCE = Mappers.getMapper(SensorPredictionMapper.class);
    @Mapping(target="sensorId", source="sensorDao.id")
    SensorPrediction sensorDaoToSensorPrediction(SensorDAO sensorDao);
    @Mapping(target="id", source="sensorPrediction.sensorId")
    SensorDAO sensorPredictionToSensorDao(SensorPrediction sensorPrediction);
}