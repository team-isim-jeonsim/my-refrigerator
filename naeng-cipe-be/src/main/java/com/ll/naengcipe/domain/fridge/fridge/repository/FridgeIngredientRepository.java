package com.ll.naengcipe.domain.fridge.fridge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.naengcipe.domain.fridge.fridge.entity.FridgeIngredient;

public interface FridgeIngredientRepository extends JpaRepository<FridgeIngredient, Long> {
	Optional<FridgeIngredient> findByFridgeIdAndIngredientId(Long fridgeId, Long ingredientId);
}
