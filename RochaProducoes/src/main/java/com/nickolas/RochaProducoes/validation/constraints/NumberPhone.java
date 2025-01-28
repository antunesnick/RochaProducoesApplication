package com.nickolas.RochaProducoes.validation.constraints;

import com.nickolas.RochaProducoes.validation.NumberPhoneValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberPhoneValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberPhone {
    String message() default "{Número de telefone inválido}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
