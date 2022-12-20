package iot.home.service.iotrest.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetHomesRequest
 */

@JsonTypeName("getHomes_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class GetHomesRequest {

  /**
   * Gets or Sets searchColumn
   */
  public enum SearchColumnEnum {
    ADDRESS("address"),
    
    DESCRIPTION("description");

    private String value;

    SearchColumnEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SearchColumnEnum fromValue(String value) {
      for (SearchColumnEnum b : SearchColumnEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("search_column")
  private SearchColumnEnum searchColumn;

  @JsonProperty("text_search")
  private String textSearch;

  public GetHomesRequest searchColumn(SearchColumnEnum searchColumn) {
    this.searchColumn = searchColumn;
    return this;
  }

  /**
   * Get searchColumn
   * @return searchColumn
  */
  
  @Schema(name = "search_column", required = false)
  public SearchColumnEnum getSearchColumn() {
    return searchColumn;
  }

  public void setSearchColumn(SearchColumnEnum searchColumn) {
    this.searchColumn = searchColumn;
  }

  public GetHomesRequest textSearch(String textSearch) {
    this.textSearch = textSearch;
    return this;
  }

  /**
   * Get textSearch
   * @return textSearch
  */
  
  @Schema(name = "text_search", required = false)
  public String getTextSearch() {
    return textSearch;
  }

  public void setTextSearch(String textSearch) {
    this.textSearch = textSearch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetHomesRequest getHomesRequest = (GetHomesRequest) o;
    return Objects.equals(this.searchColumn, getHomesRequest.searchColumn) &&
        Objects.equals(this.textSearch, getHomesRequest.textSearch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchColumn, textSearch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetHomesRequest {\n");
    sb.append("    searchColumn: ").append(toIndentedString(searchColumn)).append("\n");
    sb.append("    textSearch: ").append(toIndentedString(textSearch)).append("\n");
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

