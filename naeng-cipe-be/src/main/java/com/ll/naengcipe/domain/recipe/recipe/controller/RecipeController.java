package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.exception.KeywordIsBlankException;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Slf4j
public class RecipeController {

	private final RecipeService recipeService;

	@GetMapping
	public Page<RecipeResponseDto> recipeList(HttpServletRequest request, Pageable pageable,
		RecipeSearchCondAndKeywordDto recipeSearchDto) {
		log.info("request={}", request.getQueryString());
		log.info("pageable={}", pageable);
		log.info("recipeSearchDto={}", recipeSearchDto);
		//지정된 형식으로 cond를 보내지 않으면 MethodArgumentNotValidException 발생

		//cond는 있는데 keyword는 공백인 경우에 예외처리
		if (recipeSearchDto.getCond() != null && recipeSearchDto.isKeywordBlank()) {
			throw new KeywordIsBlankException("검색어를 입력하세요.");
		}

		return recipeService.findRecipeList(pageable, recipeSearchDto);

	}
}
