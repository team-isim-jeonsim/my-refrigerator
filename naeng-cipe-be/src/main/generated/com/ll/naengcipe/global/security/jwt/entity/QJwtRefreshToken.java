package com.ll.naengcipe.global.security.jwt.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJwtRefreshToken is a Querydsl query type for JwtRefreshToken
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJwtRefreshToken extends EntityPathBase<JwtRefreshToken> {

    private static final long serialVersionUID = -1663630003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJwtRefreshToken jwtRefreshToken = new QJwtRefreshToken("jwtRefreshToken");

    public final com.ll.naengcipe.global.entity.QBaseEntity _super = new com.ll.naengcipe.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.time.Instant> expiryDate = createDateTime("expiryDate", java.time.Instant.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.ll.naengcipe.domain.member.member.entity.QMember member;

    public final StringPath refreshToken = createString("refreshToken");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QJwtRefreshToken(String variable) {
        this(JwtRefreshToken.class, forVariable(variable), INITS);
    }

    public QJwtRefreshToken(Path<? extends JwtRefreshToken> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJwtRefreshToken(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJwtRefreshToken(PathMetadata metadata, PathInits inits) {
        this(JwtRefreshToken.class, metadata, inits);
    }

    public QJwtRefreshToken(Class<? extends JwtRefreshToken> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.ll.naengcipe.domain.member.member.entity.QMember(forProperty("member")) : null;
    }

}

