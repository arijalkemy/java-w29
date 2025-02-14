package com.bootcamp.be_java_hisp_w29_g07.validation;

import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationMessages;
import com.bootcamp.be_java_hisp_w29_g07.constants.ValidationValues;
import jakarta.validation.Constraint;
import jakarta.validation.OverridesAttribute;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@NotNull(message = ValidationMessages.FIELD_CANNOT_BE_NULL)
@NotBlank(message = ValidationMessages.FIELD_CANNOT_BE_EMPTY)
@Pattern(
        regexp = ValidationValues.STRING_VALID_CHARACTERS_REGEX,
        message = ValidationMessages.FIELD_ONLY_VALID_CHARACTERS)
public @interface ValidStringField {

    String message() default "Invalid field value";
    //@OverridesAttribute(constraint = NotNull.class, name = "message")
    //String notNullConstraintMessage() default "Field cannot be empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
