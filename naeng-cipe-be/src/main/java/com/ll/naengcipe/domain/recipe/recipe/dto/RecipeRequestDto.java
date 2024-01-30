package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RecipeRequestDto {

	private String title;
	private String content;
	private List<Long> ingredients;
	private List<MultipartFile> images;
}
