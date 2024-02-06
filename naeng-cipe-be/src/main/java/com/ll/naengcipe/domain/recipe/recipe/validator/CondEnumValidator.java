package com.ll.naengcipe.domain.recipe.recipe.validator;

import org.springframework.util.StringUtils;

import com.ll.naengcipe.domain.recipe.recipe.annotation.CondEnum;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCond;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CondEnumValidator implements ConstraintValidator<CondEnum, String> {

	@Override
	public void initialize(CondEnum constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.hasText(value)) {
			return RecipeSearchCond.isCorrectSearchCond(value);
		}
		return true;
	}
}
