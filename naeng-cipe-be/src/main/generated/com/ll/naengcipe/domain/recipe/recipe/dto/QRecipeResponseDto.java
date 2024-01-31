package com.ll.naengcipe.domain.recipe.recipe.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.ll.naengcipe.domain.recipe.recipe.dto.QRecipeResponseDto is a Querydsl Projection type for RecipeResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QRecipeResponseDto extends ConstructorExpression<RecipeResponseDto> {

    private static final long serialVersionUID = 2042915936L;

    public QRecipeResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate) {
        super(RecipeResponseDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, id, title, writer, createdDate);
    }

    public QRecipeResponseDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> thumbnail, com.querydsl.core.types.Expression<String> writer, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate) {
        super(RecipeResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.time.LocalDateTime.class}, id, title, thumbnail, writer, createdDate);
    }

}

