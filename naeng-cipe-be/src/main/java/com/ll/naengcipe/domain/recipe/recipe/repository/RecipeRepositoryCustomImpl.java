package com.ll.naengcipe.domain.recipe.recipe.repository;

import static com.ll.naengcipe.domain.member.member.entity.QMember.*;
import static com.ll.naengcipe.domain.recipe.recipe.entity.QRecipe.*;
import static com.ll.naengcipe.domain.recipe.recipe.entity.QRecipeIngredient.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.ll.naengcipe.domain.recipe.recipe.dto.QRecipeSearchResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCond;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class RecipeRepositoryCustomImpl implements RecipeRepositoryCustom {

	private final JPAQueryFactory jpaQueryFactory;

	public RecipeRepositoryCustomImpl(EntityManager em) {
		this.jpaQueryFactory = new JPAQueryFactory(em);
	}

	@Override
	public List<RecipeSearchResponseDto> findRecipesByIngredients(List<Long> ingredients) {

		return jpaQueryFactory.select(new QRecipeSearchResponseDto(
				recipe.id, recipe.title, member.nickname, recipe.createdDate))
			.from(recipe)
			.leftJoin(recipe.member, member)
			.leftJoin(recipe.recipeIngredient, recipeIngredient)
			.where(recipeIngredient.ingredient.id.in(ingredients))
			.groupBy(recipe.id)
			.having(recipeIngredient.ingredient.id.countDistinct().eq((long)ingredients.size()))
			.fetch();
	}

	@Override
	public Page<RecipeSearchResponseDto> findAllThroughSearch(Pageable pageable,
		RecipeSearchCondAndKeywordDto recipeSearchCond) {

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (StringUtils.hasText(recipeSearchCond.getCond()) && StringUtils.hasText(recipeSearchCond.getKeyword())) {
			String cond = recipeSearchCond.getCond();
			String keyword = recipeSearchCond.getKeyword();
			if (cond.equalsIgnoreCase(RecipeSearchCond.TITLE.getValue())) {
				booleanBuilder.and(recipe.title.contains(keyword));
			} else if (cond.equalsIgnoreCase(RecipeSearchCond.BODY.getValue())) {
				booleanBuilder.and(recipe.content.contains(keyword));
			} else if (cond.equalsIgnoreCase(RecipeSearchCond.TNB.getValue())) {
				booleanBuilder.and(recipe.title.contains(keyword).or(recipe.content.contains(keyword)));
			}
		}

		JPAQuery<RecipeSearchResponseDto> query = jpaQueryFactory.select(new QRecipeSearchResponseDto(
				recipe.id, recipe.title, member.nickname, recipe.createdDate))
			.from(recipe)
			.leftJoin(recipe.member, member)
			.where(booleanBuilder)
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize());

		for (Sort.Order o : pageable.getSort()) {
			PathBuilder pathBuilder = new PathBuilder(recipe.getType(), recipe.getMetadata());
			query.orderBy(
				new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(o.getProperty())));
		}

		List<RecipeSearchResponseDto> content = query.fetch();

		Long totalCount = jpaQueryFactory.select(recipe.count())
			.from(recipe)
			.leftJoin(recipe.member, member)
			.where(booleanBuilder)
			.fetchOne();

		return new PageImpl<>(content, pageable, totalCount);
	}
}
