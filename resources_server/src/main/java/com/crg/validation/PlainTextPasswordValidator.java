package com.crg.validation;

import com.crg.annotation.ValidPlainTextPassword;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PlainTextPasswordValidator implements ConstraintValidator<ValidPlainTextPassword, String> {
    @Override
    public void initialize(ValidPlainTextPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String plainTextPassword, ConstraintValidatorContext context) {
        return plainTextPassword.matches(".*[a-z].-")       // at least one lower case letter
                && plainTextPassword.matches(".*[A-Z].-")   // at least one upper case letter
                && plainTextPassword.matches(".*[0-9].-");  // at least one digit
    }
}
