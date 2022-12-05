/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package iot.home.service.iotrest.controllers;

import iot.home.service.iotrest.entities.PutUserRequest;
import iot.home.service.iotrest.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "users", description = "the users API")
public interface UsersApi {

    /**
     * DELETE /users/{user-id}
     * Deletes an existing user
     *
     * @param userId  (required)
     * @return User deleted successfully (status code 200)
     */
    @Operation(
        operationId = "deleteUserById",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/users/{user-id}"
    )
    ResponseEntity<Void> deleteUserById(
        @Parameter(name = "user-id", description = "", required = true) @PathVariable("user-id") String userId
    );


    /**
     * GET /users/{user-id}
     * Returns the specified user from the system
     *
     * @param userId  (required)
     * @return Returned a list with the user (status code 200)
     */
    @Operation(
        operationId = "getUserById",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Returned a list with the user", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/users/{user-id}",
        produces = { "application/json" }
    )
    ResponseEntity<User> getUserById(
        @Parameter(name = "user-id", description = "", required = true) @PathVariable("user-id") String userId
    );


    /**
     * POST /users/{user-id}
     * Updates an existing user
     *
     * @param userId  (required)
     * @param putUserRequest  (required)
     * @return User updated successfully (status code 200)
     */
    @Operation(
        operationId = "postUserById",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User updated successfully")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/users/{user-id}",
        consumes = { "application/json" }
    )
    ResponseEntity<Void> postUserById(
        @Parameter(name = "user-id", description = "", required = true) @PathVariable("user-id") String userId,
        @Parameter(name = "PutUserRequest", description = "", required = true) @Valid @RequestBody PutUserRequest putUserRequest
    );


    /**
     * PUT /users
     * Creates a new user with the specified data
     *
     * @param putUserRequest  (required)
     * @return User updated successfully. (status code 200)
     */
    @Operation(
        operationId = "putUser",
        tags = { "Users" },
        responses = {
            @ApiResponse(responseCode = "200", description = "User updated successfully.")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/users",
        consumes = { "application/json" }
    )
    ResponseEntity<Void> putUser(
        @Parameter(name = "PutUserRequest", description = "", required = true) @Valid @RequestBody PutUserRequest putUserRequest
    );

}
