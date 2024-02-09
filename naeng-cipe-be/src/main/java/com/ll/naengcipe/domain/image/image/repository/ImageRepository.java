package com.ll.naengcipe.domain.image.image.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.naengcipe.domain.image.image.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}


