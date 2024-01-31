package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;

import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class RecipeSearchResponseDto {

	private Long id;
	private String title;
	private String thumbnail;
	private String writer;
	private LocalDateTime createdDate;

	//Todo: 레시피 이미지 작업
	@QueryProjection //QueryDsl의 select에 new 연산자 사용하기 위함
	public RecipeSearchResponseDto(Long id, String title, String writer, LocalDateTime createdDate) {
		this.id = id;
		this.title = title;
		this.thumbnail = null;
		this.writer = writer;
		this.createdDate = createdDate;
	}

	@QueryProjection //QueryDsl의 select에 new 연산자 사용하기 위함
	public RecipeSearchResponseDto(Long id, String title, String thumbnail, String writer, LocalDateTime createdDate) {
		this.id = id;
		this.title = title;
		this.thumbnail = thumbnail;
		this.writer = writer;
		this.createdDate = createdDate;
	}

	//Todo: 레시피 이미지 작업
	public RecipeSearchResponseDto(Recipe recipe) {
		this.id = recipe.getId();
		this.title = recipe.getTitle();
		this.thumbnail = null;
		this.writer = recipe.getMember().getNickname();
		this.createdDate = recipe.getCreatedDate();
	}
}
