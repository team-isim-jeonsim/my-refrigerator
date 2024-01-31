package com.ll.naengcipe.domain.recipe.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ll.naengcipe.domain.recipe.recipe.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {

	@Modifying
	@Query("delete from RecipeIngredient ri where ri.recipe.id = :recipeId")
	void deleteByRecipeId(Long recipeId);
}
