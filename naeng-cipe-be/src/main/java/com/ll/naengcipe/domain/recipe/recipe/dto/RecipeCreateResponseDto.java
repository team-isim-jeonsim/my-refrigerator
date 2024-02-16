package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.ll.naengcipe.domain.image.image.dto.ImageResponseDto;
import com.ll.naengcipe.domain.image.image.entity.Image;
import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.entity.RecipeIngredient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeCreateResponseDto {

	private Long id;
	private String title;
	private String content;
	private List<IngredientResponseDto> ingredients;
	private List<ImageResponseDto> images;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public static RecipeCreateResponseDto toDto(Recipe recipe, List<Image> images) {
		RecipeCreateResponseDto dto = RecipeCreateResponseDto.builder()
			.id(recipe.getId())
			.title(recipe.getTitle())
			.content(recipe.getContent())
			.writer(recipe.getMember().getNickname())
			.createdDate(recipe.getCreatedDate())
			.updatedDate(recipe.getUpdatedDate())
			.build();

		dto.addIngredients(recipe.getRecipeIngredient());
		dto.addImages(images);

		return dto;
	}

	private void addImages(List<Image> images) {
		if (images == null) {
			this.images = null;
			return;
		}

		//인덱스를 위해서 사용
		AtomicInteger index = new AtomicInteger();

		this.images = images.stream()
			.map(i ->
				ImageResponseDto.builder()
					.imageUrl(i.getUrl())
					.isMainImage(index.getAndIncrement() == 0) //인덱스가 0이면 메인이미지
					.build()
			).collect(Collectors.toList());
	}

	private void addIngredients(List<RecipeIngredient> recipeIngredients) {
		this.ingredients = recipeIngredients.stream()
			.map(ri -> IngredientResponseDto.toDto(ri.getIngredient()))
			.collect(Collectors.toList());
	}
}
