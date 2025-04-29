package com.mercadolibre.final_project_bootcamp_esp_32.config;


import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ValidationExceptionDto;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.*;
import com.newrelic.api.agent.NewRelic;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * Basic handling for exceptions.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);

  /**
   * Handler for not found routes.
   * 
   * @param ex the exception thrown when route is not found.
   * @return {@link ResponseEntity} with 404 status code and the route that was
   *         not found in the body.
   */
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ApiError> noHandlerFoundException(NoHandlerFoundException ex) {
    ApiError apiError = new ApiError(
        "route_not_found",
        String.format("Route %s not found", ex.getRequestURL()),
        HttpStatus.NOT_FOUND.value());
    return ResponseEntity
        .status(apiError.getStatus())
        .body(apiError);
  }

  /**
   * Handler for external API exceptions.
   *  
   * @param e the exception thrown during a request to external API.
   * @return {@link ResponseEntity} with status code and description provided for the handled exception.
   */
  @ExceptionHandler(ApiException.class)
  protected ResponseEntity<ApiError> handleApiException(ApiException e) {
    Integer statusCode = e.getStatusCode();
    boolean expected = HttpStatus.INTERNAL_SERVER_ERROR.value() > statusCode;
    NewRelic.noticeError(e, expected);
    if (expected) {
      LOGGER.warn("Internal Api warn. Status Code: " + statusCode, e);
    } else {
      LOGGER.error("Internal Api error. Status Code: " + statusCode, e);
    }

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), statusCode);
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  /**
   * Handler for internal exceptions.
   * 
   * @param e the exception thrown during request processing.
   * @return {@link ResponseEntity} with 500 status code and description indicating an internal error.
   */
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ApiError> handleUnknownException(Exception e) {
    LOGGER.error("Internal error", e);
    NewRelic.noticeError(e);

    ApiError apiError =
        new ApiError(
            "internal_error", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(NotFoundException.class)
  protected ResponseEntity<ApiError> handleNotFoundException(NotFoundException e) {
    LOGGER.error("Not found error", e);
    NewRelic.noticeError(e);

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(BatchAlreadyExistsException.class)
  protected ResponseEntity<ApiError> BatchAlreadyExistsException(BatchAlreadyExistsException e) {
    LOGGER.error("Batch already exists  error", e);
    NewRelic.noticeError(e);

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), HttpStatus.CONFLICT.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<ApiError> BadRequestException(BadRequestException e) {
    LOGGER.error("Bad request error", e);
    NewRelic.noticeError(e);

    ApiError apiError = new ApiError(e.getCode(), e.getDescription(), HttpStatus.BAD_REQUEST.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ValidationExceptionDto> handleValidationExceptions(ConstraintViolationException exception) {
    Map<String, String> errors = new HashMap<>();
    exception.getConstraintViolations().forEach(error->
            errors.put(error.getPropertyPath().toString(), error.getMessage()));
    ValidationExceptionDto dto = new ValidationExceptionDto(errors);
    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
  }
}
