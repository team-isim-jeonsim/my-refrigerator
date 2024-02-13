package com.ll.naengcipe.global.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.ll.naengcipe.domain.image.image.entity.Image;
import com.ll.naengcipe.domain.image.image.repository.ImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileService {

	private final AmazonS3 amazonS3;
	private final ImageRepository imageRepository;

	@Value("${aws.s3.bucket}")
	private String bucket;

	@Transactional
	public List<Image> uploadImage(List<MultipartFile> multipartFiles) {
		List<Image> images = new ArrayList<>();
		//S3에 이미지 저장
		for (MultipartFile multipartFile : multipartFiles) {

			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(multipartFile.getSize());
			metadata.setContentType(multipartFile.getContentType());

			//S3에 '년/월/일/UUID_파일이름' 으로 저장
			LocalDate now = LocalDate.now();
			String datePath = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/"));
			String imageName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
			String keyName = datePath + imageName;

			try {
				amazonS3.putObject(
					new PutObjectRequest(bucket, keyName, multipartFile.getInputStream(), metadata));
				String imageUrl = amazonS3.getUrl(bucket, keyName).toString();

				Image image = Image.builder()
					.keyName(keyName)
					.imageName(imageName)
					.url(imageUrl)
					.size(multipartFile.getSize())
					.build();

				images.add(image);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		//이미지 리스트가 비어있으면 null 반환
		return images.isEmpty() ? null : images;
	}
}
