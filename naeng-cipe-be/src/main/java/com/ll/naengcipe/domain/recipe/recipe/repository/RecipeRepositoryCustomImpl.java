package com.ll.naengcipe.domain.recipe.recipe.repository;

import static com.ll.naengcipe.domain.member.member.entity.QMember.*;
import static com.ll.naengcipe.domain.recipe.recipe.entity.QRecipe.*;
import static com.ll.naengcipe.domain.recipe.recipe.entity.QRecipeIngredient.*;

import java.util.List;

import com.ll.naengcipe.domain.recipe.recipe.dto.QRecipeResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	public RecipeRepositoryCustomImpl(EntityManager em) {
		this.jpaQueryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<RecipeResponseDto> findRecipesByIngredients(List<Long> ingredients) {

		return jpaQueryFactory.select(new QRecipeResponseDto(
				recipe.id, recipe.title, member.nickname, recipe.createdDate))
			.from(recipe)
			.leftJoin(recipe.member, member)
			.leftJoin(recipe.recipeIngredient, recipeIngredient)
			.where(recipeIngredient.ingredient.id.in(ingredients))
			.groupBy(recipe.id)
			.having(recipeIngredient.ingredient.id.countDistinct().eq((long)ingredients.size()))
			.fetch();
	}
}
