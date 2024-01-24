package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.entity.Recipe;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Slf4j
public class RecipeController {

	private final RecipeService recipeService;

	@GetMapping
	public Page<RecipeResponseDto> recipeList(Pageable pageable, RecipeSearchCondAndKeywordDto recipeSearchDto) {

		log.info("pageable={}",pageable);
		log.info("recipeSearchDto={}",recipeSearchDto);
		//Todo: 지정된 형식으로 cond를 보내지 않으면 MethodArgumentNotValidException 발생

		Page<Recipe> pageRecipe = recipeService.findRecipeList(pageable,recipeSearchDto);

		//Recipe 엔티티를 컨트롤러에서 DTO로 변경
		return pageRecipe.map(recipe -> new RecipeResponseDto(recipe));
	}
}
