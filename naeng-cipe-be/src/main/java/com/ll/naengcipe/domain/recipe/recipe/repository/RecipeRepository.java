package com.ll.naengcipe.domain.recipe.recipe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, RecipeRepositoryCustom {
	@Query(value = """
		SELECT Ingredient.name 
		FROM Recipe_Ingredient 
		JOIN Ingredient 
		WHERE Recipe_Ingredient.id = :recipeId
		""", nativeQuery = true)
	List<String> getIngredientNameByRecipe(Long recipeId);

}
