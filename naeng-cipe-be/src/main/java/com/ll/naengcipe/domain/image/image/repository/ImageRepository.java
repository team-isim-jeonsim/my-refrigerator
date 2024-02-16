package com.ll.naengcipe.domain.image.image.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.naengcipe.domain.image.image.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	List<Image> findByRecipeId(Long recipeId);

	Image findFirstByRecipeId(Long recipeId);
}


