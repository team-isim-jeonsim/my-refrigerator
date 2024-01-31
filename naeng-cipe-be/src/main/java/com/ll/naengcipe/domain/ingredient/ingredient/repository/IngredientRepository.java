package com.ll.naengcipe.domain.ingredient.ingredient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	List<Ingredient> findByIdIn(List<Long> ingredientIds);
}
