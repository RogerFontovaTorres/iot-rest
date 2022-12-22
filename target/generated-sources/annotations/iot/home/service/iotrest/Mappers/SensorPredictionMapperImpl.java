package iot.home.service.iotrest.Mappers;

import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dto.SensorPrediction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-22T02:17:39+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class SensorPredictionMapperImpl implements SensorPredictionMapper {

    @Override
    public SensorPrediction sensorDaoToSensorPrediction(SensorDAO sensorDao) {
        if ( sensorDao == null ) {
            return null;
        }

        SensorPrediction sensorPrediction = new SensorPrediction();

        sensorPrediction.setSensorId( sensorDao.getId() );
        sensorPrediction.setHomeId( sensorDao.getHomeId() );
        sensorPrediction.setRoom( sensorDao.getRoom() );

        return sensorPrediction;
    }

    @Override
    public SensorDAO sensorPredictionToSensorDao(SensorPrediction sensorPrediction) {
        if ( sensorPrediction == null ) {
            return null;
        }

        SensorDAO sensorDAO = new SensorDAO();

        sensorDAO.setId( sensorPrediction.getSensorId() );
        sensorDAO.setHomeId( sensorPrediction.getHomeId() );
        sensorDAO.setRoom( sensorPrediction.getRoom() );

        return sensorDAO;
    }
}
