package com.ll.naengcipe.domain.fridge.fridge.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ll.naengcipe.domain.ingredient.ingredient.entity.Ingredient;
import com.ll.naengcipe.domain.member.member.entity.Member;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Fridge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "fridge", cascade = CascadeType.PERSIST)
	private Set<FridgeIngredient> fridgeIngredients = new HashSet<>();

	public void addIngredient(Ingredient ingredient) {
		FridgeIngredient fridgeIngredient = FridgeIngredient.builder()
			.fridge(this)
			.ingredient(ingredient)
			.createdDate(LocalDateTime.now())
			.build();

		fridgeIngredients.add(fridgeIngredient);
	}

	public void removeIngredient(Ingredient ingredient) {
		FridgeIngredient fridgeIngredient = FridgeIngredient.builder()
			.fridge(this)
			.ingredient(ingredient)
			.createdDate(LocalDateTime.now())
			.build();

		fridgeIngredients.remove(fridgeIngredient);
	}
}
