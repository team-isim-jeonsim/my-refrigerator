package com.ll.naengcipe.domain.fridge.fridge.repository;

import com.ll.naengcipe.domain.fridge.fridge.entity.Fridge;
import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge,Long> {
	Fridge findByMemberId(Long memberId);
}
