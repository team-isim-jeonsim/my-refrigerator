package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class RecipeSearchResponseDto {

	private Long id;
	private String title;
	private String thumbnail;
	private String writer;
	private LocalDateTime createdDate;

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
}
