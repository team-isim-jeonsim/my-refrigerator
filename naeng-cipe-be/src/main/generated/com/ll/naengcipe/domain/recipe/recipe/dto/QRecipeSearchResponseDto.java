package com.ll.naengcipe.domain.recipe.recipe.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.ll.naengcipe.domain.recipe.recipe.dto.QRecipeSearchResponseDto is a Querydsl Projection type for RecipeSearchResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRecipeSearchResponseDto extends ConstructorExpression<RecipeSearchResponseDto> {

    private static final long serialVersionUID = -1634948072L;

    public QRecipeSearchResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate) {
        super(RecipeSearchResponseDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, id, title, writer, createdDate);
    }

    public QRecipeSearchResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> thumbnail, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate) {
        super(RecipeSearchResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class}, id, title, thumbnail, writer, createdDate);
    }

}

