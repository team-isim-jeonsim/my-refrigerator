package com.ll.naengcipe.domain.image.image.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageResponseDto {
	private String imageUrl;
	private boolean isMainImage;
}
