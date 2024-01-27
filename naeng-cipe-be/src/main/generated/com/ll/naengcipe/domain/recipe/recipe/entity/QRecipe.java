package com.ll.naengcipe.domain.recipe.recipe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipe is a Querydsl query type for Recipe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipe extends EntityPathBase<Recipe> {

    private static final long serialVersionUID = 55928952L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipe recipe = new QRecipe("recipe");

    public final com.ll.naengcipe.global.entity.QBaseEntity _super = new com.ll.naengcipe.global.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.ll.naengcipe.domain.member.member.entity.QMember member;

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipeIngredient = this.<RecipeIngredient, QRecipeIngredient>createList("recipeIngredient", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QRecipe(String variable) {
        this(Recipe.class, forVariable(variable), INITS);
    }

    public QRecipe(Path<? extends Recipe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecipe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecipe(PathMetadata metadata, PathInits inits) {
        this(Recipe.class, metadata, inits);
    }

    public QRecipe(Class<? extends Recipe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.ll.naengcipe.domain.member.member.entity.QMember(forProperty("member")) : null;
    }

}

