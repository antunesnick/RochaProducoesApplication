package com.nickolas.RochaProducoes.validation;

import com.nickolas.RochaProducoes.validation.constraints.NumberPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberPhoneValidation implements ConstraintValidator<NumberPhone, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String phoneNumber = s == null ? "" : s.trim();
        String regex = "^\\(?(\\d{2})\\)?\\s?(9?\\d{4})[-\\s]?(\\d{4})$";
        return phoneNumber.matches(regex);
    }
}
