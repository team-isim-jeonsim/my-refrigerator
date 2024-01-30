package com.ll.naengcipe.domain.ingredient.ingredient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.ingredient.ingredient.repository.IngredientRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IngredientService {

	private final IngredientRepository ingredientRepository;

	@Transactional
	public List<Ingredient> findIngredient() {
		return ingredientRepository.findAll();
	}

	@Transactional
	public Optional<Ingredient> findById(Long id){
		return ingredientRepository.findById(id);
	}
}
