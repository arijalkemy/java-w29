package com.bootcamp.be_java_hisp_w29_g07.validation;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationMessages;
import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
@NotNull(message = ValidationMessages.ID_CANNOT_BE_EMPTY)
@Min(value = ValidationValues.MIN_ID, message = ValidationMessages.ID_MUST_BE_GREATER_THAN_ZERO)
public @interface ValidID {
    String message() default "Invalid id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
