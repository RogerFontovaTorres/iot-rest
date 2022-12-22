package iot.home.service.iotrest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SensorPrediction
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class SensorPrediction {

  @JsonProperty("sensor_id")
  private String sensorId;

  @JsonProperty("home_id")
  private Integer homeId;

  @JsonProperty("room")
  private String room;

  @JsonProperty("temperature")
  private Double temperature;

  public SensorPrediction sensorId(String sensorId) {
    this.sensorId = sensorId;
    return this;
  }

  /**
   * Get sensorId
   * @return sensorId
  */
  
  @Schema(name = "sensor_id", required = false)
  public String getSensorId() {
    return sensorId;
  }

  public void setSensorId(String sensorId) {
    this.sensorId = sensorId;
  }

  public SensorPrediction homeId(Integer homeId) {
    this.homeId = homeId;
    return this;
  }

  /**
   * Get homeId
   * @return homeId
  */
  
  @Schema(name = "home_id", required = false)
  public Integer getHomeId() {
    return homeId;
  }

  public void setHomeId(Integer homeId) {
    this.homeId = homeId;
  }

  public SensorPrediction room(String room) {
    this.room = room;
    return this;
  }

  /**
   * Get room
   * @return room
  */
  
  @Schema(name = "room", required = false)
  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public SensorPrediction temperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
  */
  
  @Schema(name = "temperature", required = false)
  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorPrediction sensorPrediction = (SensorPrediction) o;
    return Objects.equals(this.sensorId, sensorPrediction.sensorId) &&
        Objects.equals(this.homeId, sensorPrediction.homeId) &&
        Objects.equals(this.room, sensorPrediction.room) &&
        Objects.equals(this.temperature, sensorPrediction.temperature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sensorId, homeId, room, temperature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorPrediction {\n");
    sb.append("    sensorId: ").append(toIndentedString(sensorId)).append("\n");
    sb.append("    homeId: ").append(toIndentedString(homeId)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
