package iot.home.service.iotrest.entities;

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
 * Home where sensors will be located
 */

@Schema(name = "Home", description = "Home where sensors will be located")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Home {

  @JsonProperty("home_id")
  private Integer homeId;

  @JsonProperty("owner_id")
  private Integer ownerId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("address")
  private String address;

  @JsonProperty("description")
  private String description;

  public Home homeId(Integer homeId) {
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

  public Home ownerId(Integer ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * Get ownerId
   * @return ownerId
  */
  
  @Schema(name = "owner_id", required = false)
  public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public Home name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Home address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", required = false)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Home description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description", required = false)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Home home = (Home) o;
    return Objects.equals(this.homeId, home.homeId) &&
        Objects.equals(this.ownerId, home.ownerId) &&
        Objects.equals(this.name, home.name) &&
        Objects.equals(this.address, home.address) &&
        Objects.equals(this.description, home.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homeId, ownerId, name, address, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Home {\n");
    sb.append("    homeId: ").append(toIndentedString(homeId)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

