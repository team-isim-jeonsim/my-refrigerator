package com.ll.naengcipe.domain.fridge.fridge.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFridge is a Querydsl query type for Fridge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFridge extends EntityPathBase<Fridge> {

    private static final long serialVersionUID = -1724433137L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFridge fridge = new QFridge("fridge");

    public final SetPath<FridgeIngredient, QFridgeIngredient> fridgeIngredients = this.<FridgeIngredient, QFridgeIngredient>createSet("fridgeIngredients", FridgeIngredient.class, QFridgeIngredient.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.ll.naengcipe.domain.member.member.entity.QMember member;

    public QFridge(String variable) {
        this(Fridge.class, forVariable(variable), INITS);
    }

    public QFridge(Path<? extends Fridge> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFridge(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFridge(PathMetadata metadata, PathInits inits) {
        this(Fridge.class, metadata, inits);
    }

    public QFridge(Class<? extends Fridge> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.ll.naengcipe.domain.member.member.entity.QMember(forProperty("member")) : null;
    }

}

