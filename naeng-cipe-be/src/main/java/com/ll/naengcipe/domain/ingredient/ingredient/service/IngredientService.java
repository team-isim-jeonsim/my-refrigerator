package com.ll.naengcipe.domain.ingredient.ingredient.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientCreateRequestDto;
import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;
import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.ingredient.ingredient.exception.IngredientNotUniqueException;
import com.ll.naengcipe.domain.ingredient.ingredient.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class IngredientService {

	private final IngredientRepository ingredientRepository;

	public List<Ingredient> findIngredient() {
		return ingredientRepository.findAll();
	}

	@Transactional
	public IngredientResponseDto addIngredient(IngredientCreateRequestDto ingredientDto) {
		
		//해당 이름의 재료가 이미 존재하면 예외처리
		if (ingredientRepository.existsByName(ingredientDto.getName())) {
			throw new IngredientNotUniqueException("해당 이름의 재료가 이미 존재합니다.");
		}

		Ingredient savedIngredient = ingredientRepository.save(new Ingredient(ingredientDto.getName()));
		return IngredientResponseDto.toDto(savedIngredient);
	}
}
