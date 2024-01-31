package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeCreateRequestDto {

	private Long id;
	private String title;
	private String content;
	private List<Long> ingredients;
	private List<MultipartFile> images;
}
