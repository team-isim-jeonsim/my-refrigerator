package com.ll.naengcipe.domain.recipe.recipe.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeCreateResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeInfoResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchCondAndKeywordDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeSearchResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateRequestDto;
import com.ll.naengcipe.domain.recipe.recipe.dto.RecipeUpdateResponseDto;
import com.ll.naengcipe.domain.recipe.recipe.exception.KeywordIsBlankException;
import com.ll.naengcipe.domain.recipe.recipe.service.RecipeService;
import com.ll.naengcipe.global.security.authentiation.UserPrincipal;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
@Slf4j
public class RecipeController {

	private final RecipeService recipeService;

	/*@PreAuthorize("isAuthenticated()")
	@PostMapping
	public ResponseEntity<?> recipeAdd(
		@AuthenticationPrincipal UserPrincipal user,
		@RequestBody RecipeCreateRequestDto recipeCreateDto) {

		RecipeCreateResponseDto recipeResponseDto = recipeService.addRecipe(user.getMember(), recipeCreateDto);
		return
			ResponseEntity.status(HttpStatus.CREATED).body(recipeResponseDto);
	}*/

	@PreAuthorize("isAuthenticated()")
	@PatchMapping("/{recipeId}")
	public ResponseEntity<?> recipeModify(@AuthenticationPrincipal UserPrincipal user,
		@RequestBody RecipeUpdateRequestDto recipeUpdateDto) {

		RecipeUpdateResponseDto updateResponseDto = recipeService.modifyRecipe(user.getMember(), recipeUpdateDto);

		return ResponseEntity.ok(updateResponseDto);
	}

	@PreAuthorize("isAuthenticated()")
	@DeleteMapping("/{recipeId}")
	public ResponseEntity<?> recipeRemove(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long recipeId) {

		recipeService.removeRecipe(user.getMember(), recipeId);

		return ResponseEntity.ok(null);
	}

	@GetMapping("/{recipeId}")
	public ResponseEntity<RecipeInfoResponseDto> recipeDetails(@PathVariable Long recipeId) {
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.findRecipe(recipeId));
	}

	@GetMapping
	public ResponseEntity<Page<RecipeSearchResponseDto>> recipeList(Pageable pageable,
		@Valid RecipeSearchCondAndKeywordDto recipeSearchDto) {

		//cond는 있는데 keyword는 공백인 경우에 예외처리
		if (recipeSearchDto.getCond() != null && recipeSearchDto.isKeywordBlank()) {
			throw new KeywordIsBlankException("검색어를 입력하세요.");
		}

		return ResponseEntity.ok(recipeService.findRecipeList(pageable, recipeSearchDto));
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> recipeAddWithImage(
		@AuthenticationPrincipal UserPrincipal user,
		@ModelAttribute RecipeCreateRequestDto recipeCreateDto) {

		RecipeCreateResponseDto recipeResponseDto = recipeService.addRecipe(user.getMember(), recipeCreateDto);
		return
			ResponseEntity.status(HttpStatus.CREATED).body(recipeResponseDto);
	}

}
