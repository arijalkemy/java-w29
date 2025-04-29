package com.mercadolibre.final_project_bootcamp_esp_32.unit.exceptions;

import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.InternalServerErrorException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InternalServerErrorExceptionTest {

        @Test
        public void testConstructorWithCause() {
            Throwable cause = new RuntimeException("Some internal error");

            InternalServerErrorException exception = new InternalServerErrorException(cause);

            //assertEquals("internal_error", exception.getErrorCode());
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage());
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getStatusCode());
            assertEquals(cause, exception.getCause());
        }

        @Test
        public void testConstructorWithMessageAndCause() {
            String customMessage = "A custom internal error message";
            Throwable cause = new RuntimeException("Some internal error");

            InternalServerErrorException exception = new InternalServerErrorException(customMessage, cause);

            //assertEquals("internal_error", exception.getErrorCode());
            assertEquals(customMessage, exception.getMessage());
            assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getStatusCode());
            assertEquals(cause, exception.getCause());
        }
    }

