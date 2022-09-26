package com.azelewski.springproject.validation;

import com.azelewski.springproject.infrastructure.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO user = (UserDTO) o;
        return user.getPassword().equals(user.getMatchingPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
}
