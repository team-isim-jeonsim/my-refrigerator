package com.ll.naengcipe.domain.recipe.recipe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, RecipeRepositoryCustom {
	@Query("select r from Recipe r left join fetch r.recipeIngredient ri where r.id = :recipeId")
	Optional<Recipe> findByIdWithRecipeIngredient(Long recipeId);
}
