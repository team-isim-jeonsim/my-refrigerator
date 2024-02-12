package com.ll.naengcipe.domain.ingredient.ingredient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	boolean existsByName(String ingredientName);

	List<Ingredient> findByIdIn(List<Long> ingredientIds);
}
