package com.ll.naengcipe.domain.fridge.fridge.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFridgeIngredient is a Querydsl query type for FridgeIngredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFridgeIngredient extends EntityPathBase<FridgeIngredient> {

    private static final long serialVersionUID = 1660535872L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFridgeIngredient fridgeIngredient = new QFridgeIngredient("fridgeIngredient");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final QFridge fridge;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.ll.naengcipe.domain.ingredient.ingredient.entity.QIngredient ingredient;

    public QFridgeIngredient(String variable) {
        this(FridgeIngredient.class, forVariable(variable), INITS);
    }

    public QFridgeIngredient(Path<? extends FridgeIngredient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFridgeIngredient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFridgeIngredient(PathMetadata metadata, PathInits inits) {
        this(FridgeIngredient.class, metadata, inits);
    }

    public QFridgeIngredient(Class<? extends FridgeIngredient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fridge = inits.isInitialized("fridge") ? new QFridge(forProperty("fridge"), inits.get("fridge")) : null;
        this.ingredient = inits.isInitialized("ingredient") ? new com.ll.naengcipe.domain.ingredient.ingredient.entity.QIngredient(forProperty("ingredient")) : null;
    }

}

