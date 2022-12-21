package iot.home.service.iotrest.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;

import java.time.Instant;

@Measurement(name = "temperature-prediction")
public class TemperaturePrediction {

    @Column(timestamp = true)
    private Instant time;

    @Column
    private double prediction;

    @Column
    private double predictionLower;

    @Column
    private double predictionUpper;

    @Column(tag = true)
    private String sensorId;
}