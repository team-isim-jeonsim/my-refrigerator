package com.ll.naengcipe.domain.recipe.recipe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, RecipeRepositoryCustom {

	@EntityGraph(attributePaths = "member") //member 페치조인
	@Query("select r from Recipe r")
	public Page<Recipe> findAllWithMember(Pageable pageable);
}
