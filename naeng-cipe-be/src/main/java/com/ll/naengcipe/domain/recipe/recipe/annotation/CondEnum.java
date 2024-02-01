package com.ll.naengcipe.domain.recipe.recipe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ll.naengcipe.domain.recipe.recipe.validator.CondEnumValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = {CondEnumValidator.class}) //해당 애노테이션을 검증할 검증기
@Target({ElementType.FIELD}) //애노테이션을 필드에 적용.
@Retention(RetentionPolicy.RUNTIME) //애노테이션을 Runtime까지 유지.
public @interface CondEnum {

	String message() default "검색 조건이 올바르지 않습니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
