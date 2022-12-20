package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.Sensor;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-20T16:07:16+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class SensorMapperImpl implements SensorMapper {

    @Override
    public Sensor sensorDaoToSensorDto(SensorDAO sensorDao) {
        if ( sensorDao == null ) {
            return null;
        }

        Sensor sensor = new Sensor();

        sensor.setSensorId( sensorDao.getId() );
        sensor.setHomeId( sensorDao.getHomeId() );
        sensor.setRoom( sensorDao.getRoom() );

        return sensor;
    }

    @Override
    public SensorDAO sensorDtoToSensorDao(Sensor sensorDto) {
        if ( sensorDto == null ) {
            return null;
        }

        SensorDAO sensorDAO = new SensorDAO();

        sensorDAO.setId( sensorDto.getSensorId() );
        sensorDAO.setHomeId( sensorDto.getHomeId() );
        sensorDAO.setRoom( sensorDto.getRoom() );

        return sensorDAO;
    }
}
