package iot.home.service.iotrest.services;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.QueryApi;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;
import com.influxdb.query.internal.FluxCsvParser;
import iot.home.service.iotrest.Mappers.SensorMapper;
import iot.home.service.iotrest.Mappers.SensorPredictionMapper;
import iot.home.service.iotrest.dao.HomeDAO;
import iot.home.service.iotrest.dao.SensorDAO;
import iot.home.service.iotrest.dao.UserDAO;
import iot.home.service.iotrest.dto.PostPutReturn;
import iot.home.service.iotrest.dto.PutSensorRequest;
import iot.home.service.iotrest.dto.Sensor;

import iot.home.service.iotrest.dto.SensorPrediction;
import iot.home.service.iotrest.repositories.SensorRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    InfluxDBClient database = InfluxDBClientFactory.create("http://localhost:8086", "asdf12341234asdf".toCharArray(), "iot-home-network", "iot-bucket");
    private final SensorMapper sensorMapper = SensorMapper.INSTANCE;
    private final SensorPredictionMapper sensorPredictionMapper = SensorPredictionMapper.INSTANCE;

    public boolean checkSensorAccess(UserDAO user, String sensorId) {
        return sensorRepository.findSensorDAOByIdAndOwnerId(sensorId, user.getId()) != null;
    }

    public List<Sensor> getSensorByHomeId(Integer sensorId){
        List<SensorDAO> sensorsDAO = sensorRepository.findSensorDAOByHomeId(sensorId);
        List<Sensor> sensors = new ArrayList<>();
        for(SensorDAO sensorDao: sensorsDAO){
            sensors.add(sensorMapper.sensorDaoToSensorDto(sensorDao));
        }
        return sensors;
    }

    public void deleteSensor(String sensorId){
        sensorRepository.findSensorDAOById(sensorId).ifPresent(sensor -> sensorRepository.delete(sensor));
    }

    public void saveSensor(Sensor sensorDto, UserDAO user){
        SensorDAO sensor = sensorMapper.sensorDtoToSensorDao(sensorDto);
        sensorRepository.save(sensor);

    }

    public List<SensorPrediction> getSensorById(String sensorId){
        Optional<SensorDAO> sensorDao = sensorRepository.findSensorDAOById(sensorId);
        if(!sensorDao.isPresent()){
            QueryApi queryApi = database.getQueryApi();
            Instant startTime = Instant.parse("2022-01-01T00:00:00Z");
            Instant endTime = Instant.now();
            List<FluxTable> tables = queryApi.query("from(bucket: \"iot-bucket\")\n" +
                    "  |> range(start: " + startTime + ", stop: " + endTime + ")\n" +
                    "  |> filter(fn: (r) => r._measurement == \"temperature-prediction\")\n" +
                    "  |> filter(fn: (r) => r.sensorId == \"" + sensorId + "\")\n" +
                    "  |> yield()");


            List<SensorPrediction> sensorsPredictions = new ArrayList<>();
            for(FluxTable table : tables){
                for(FluxRecord record : table.getRecords()){
                    Double prediction = (Double) record.getValue();
                    SensorPrediction sensorPrediction = sensorPredictionMapper.sensorDaoToSensorPrediction(sensorDao.get());
                    sensorPrediction.setTemperature(prediction);
                    sensorsPredictions.add(sensorPrediction);
                }
            }
            return sensorsPredictions;

        }
        return new ArrayList<>();
    }
}
