package com.ll.naengcipe.domain.recipe.recipe.validator;

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

		return RecipeSearchCond.isCorrectSearchCond(value);
	}
}
