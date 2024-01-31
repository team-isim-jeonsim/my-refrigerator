package com.ll.naengcipe.domain.recipe.recipe.entity;

import static jakarta.persistence.GenerationType.*;

import java.util.ArrayList;
import java.util.List;

import com.ll.naengcipe.domain.member.member.entity.Member;
import com.ll.naengcipe.global.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Recipe extends BaseEntity {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
	private List<RecipeIngredient> recipeIngredient = new ArrayList<>();
	private String title;
	private String content;

	protected Recipe(Member member, String title, String content) {
		this.member = member;
		this.title = title;
		this.content = content;
	}

	//생성메서드
	public static Recipe createRecipe(Member member, String title, String content,
		List<RecipeIngredient> recipeIngredients) {
		Recipe recipe = new Recipe(member, title, content);

		for (RecipeIngredient recipeIngredient : recipeIngredients) {
			recipe.addRecipeIngredient(recipeIngredient);
		}

		return recipe;
	}

	private void addRecipeIngredient(RecipeIngredient recipeIngredient) {
		recipeIngredient.addRecipe(this);
		this.recipeIngredient.add(recipeIngredient);
	}

	public void change(Member member, String title, String content, List<RecipeIngredient> recipeIngredients) {
		this.member = member;
		this.title = title;
		this.content = content;
		this.recipeIngredient = new ArrayList<>();
		for (RecipeIngredient recipeIngredient : recipeIngredients) {
			this.addRecipeIngredient(recipeIngredient);
		}
	}
}

