package iot.home.service.iotrest.entities;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PutSensorRequest
 */

@JsonTypeName("putSensor_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PutSensorRequest {

  @JsonProperty("home_id")
  private Integer homeId;

  @JsonProperty("room")
  private String room;

  public PutSensorRequest homeId(Integer homeId) {
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

  public PutSensorRequest room(String room) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PutSensorRequest putSensorRequest = (PutSensorRequest) o;
    return Objects.equals(this.homeId, putSensorRequest.homeId) &&
        Objects.equals(this.room, putSensorRequest.room);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homeId, room);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutSensorRequest {\n");
    sb.append("    homeId: ").append(toIndentedString(homeId)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
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

