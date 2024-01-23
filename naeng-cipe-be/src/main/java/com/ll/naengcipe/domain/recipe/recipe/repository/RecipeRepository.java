package com.ll.naengcipe.domain.recipe.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, RecipeRepositoryCustom {
}
