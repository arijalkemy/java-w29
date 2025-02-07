package com.thiagoschreck.local.melisocial.exception;

import com.thiagoschreck.local.melisocial.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleProductAlreadyExistsException(ProductAlreadyExistsException exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(exception = {ClientNotFoundException.class, SellerNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(value = IdMustNotBeNullException.class)
    public ResponseEntity<ErrorResponse> handleIdMustNotBeNullException(IdMustNotBeNullException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(UserNotFollowingSellerException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFollowingSellerException(UserNotFollowingSellerException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MissingUsernameException.class)
    public ResponseEntity<ErrorResponse> handleMissingUsernameException(MissingUsernameException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(value = InvalidSortOrderException.class)
    public ResponseEntity<ErrorResponse> handleInvalidSortOrderException(InvalidSortOrderException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler(UserAlreadyFollowingSellerException.class)
    public ResponseEntity<ErrorResponse> handleUserFollowingSellerException(UserAlreadyFollowingSellerException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(exception = {DiscountMustHaveValidValueException.class, HasDiscountMustBeTrueException.class})
    public ResponseEntity<ErrorResponse> handlePostDiscountExceptions(Exception e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidOrderValueException.class)
    public ResponseEntity<ErrorResponse> handleInvalidOrderValueException(Exception e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
