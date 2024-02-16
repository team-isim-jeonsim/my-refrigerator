package com.ll.naengcipe.domain.recipe.recipe.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.ll.naengcipe.domain.image.image.dto.ImageResponseDto;
import com.ll.naengcipe.domain.image.image.entity.Image;
import com.ll.naengcipe.domain.ingredient.ingredient.dto.IngredientResponseDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecipeInfoResponseDto {

	private Long id;
	private String title;
	private String content;
	private List<IngredientResponseDto> ingredients;
	private List<ImageResponseDto> images;
	private String writer;
	private LocalDateTime createdDate;
	private LocalDateTime updateDate;

	public void addImages(List<Image> images) {
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
}
