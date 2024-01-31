INSERT INTO MEMBER (ID, NICKNAME, PASSWORD, EMAIL, CREATED_DATE, UPDATED_DATE) VALUES (default, 'user1', '$2a$10$RipmJ2.1x5wRiO5Dx4a2SeAZRfWDiKCQEezI9TzAiP5yAfiH5jIhK', 'nana@naver.com', NOW(), NOW());
INSERT INTO MEMBER (ID, NICKNAME, PASSWORD, EMAIL, CREATED_DATE, UPDATED_DATE) VALUES (default, 'user2', '$2a$10$9bixt37laSFs1yvC6F/b9u4WUNqaJVRcxLPdjJU2vAZBDnxgmzmxq', 'nana2@naver.com', NOW(), NOW());

INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'백종원 닭튀김 고급진 레시피', '백종원 셰프의 닭튀김 비법을 따라 만든 고급진 레시피입니다. 바삭하고 촉촉한 닭튀김을 즐겨보세요.', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'무엿으로 만든 부드러운 소불고기', '무엿을 넣어 소고기를 부드럽고 달콤하게 만드는 소불고기 레시피입니다. 채소와 함께 볶아 맛과 영양을 더하세요.', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'치즈가 듬뿍 들어간 감자그라탕', '치즈와 우유, 크림을 넣어 감자를 구운 프랑스 요리인 감자그라탕 레시피입니다. 오븐에 구워서 바삭하고 부드러운 맛을 즐겨보세요.', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'매콤한 김치찌개', '김치와 돼지고기, 두부를 넣어 매콤하고 깊은 맛을 내는 김치찌개 레시피입니다. 김치는 잘 익은 것을 사용하면 더 맛있어요.', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'달콤한 호박죽', '호박과 찹쌀, 설탕을 넣어 달콤하고 영양가 있는 호박죽 레시피입니다. 호박은 쪄서 퓨레로 만들어주세요.', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'간단한 계란말이', '계란과 소금, 후추, 대파를 넣어 맛있는 계란말이 레시피입니다. 프라이팬에 기름을 두르고 계란물을 부어주세요.', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'쫄깃한 잡채', '당면과 채소, 고기를 넣어 양념장으로 버무린 잡채 레시피입니다. 당면은 물에 불려서 삶아주세요.', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'건강한 시금치나물', '시금치와 마늘, 참기름, 소금을 넣어 간단하게 만드는 시금치나물 레시피입니다. 시금치는 끓는 물에 데친 후 찬물에 헹궈주세요.', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'부드러운 스테이크', '등심 스테이크와 소금, 후추, 버터, 로즈마리를 넣어 고기의 맛을 살린 스테이크 레시피입니다. 고기는 두께가 2cm 정도 되도록 자르고, 실온에서 30분 정도 놓아주세요.', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'상큼한 레몬에이드', '레몬과 설탕, 물을 넣어 상큼하고 시원한 레몬에이드 레시피입니다. 레몬은 껍질을 벗기고 즙을 짜주세요.', 2 ,NOW(), NOW());

INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE1', 'CONTENT1', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE2', 'CONTENT2', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE3', 'CONTENT3', 1 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE4', 'CONTENT4', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE5', 'CONTENT5', 2 ,NOW(), NOW());
INSERT INTO RECIPE (ID, TITLE, CONTENT, MEMBER_ID,CREATED_DATE, UPDATED_DATE) VALUES (default,'TITLE6', 'CONTENT6', 2 ,NOW(), NOW());

-- 재료 추가
INSERT INTO INGREDIENT (id, name) VALUES (default, '닭');
INSERT INTO INGREDIENT (id, name) VALUES (default, '무엿');
INSERT INTO INGREDIENT (id, name) VALUES (default, '치즈');
INSERT INTO INGREDIENT (id, name) VALUES (default, '우유');
INSERT INTO INGREDIENT (id, name) VALUES (default, '크림');
INSERT INTO INGREDIENT (id, name) VALUES (default, '김치');
INSERT INTO INGREDIENT (id, name) VALUES (default, '돼지고기');
INSERT INTO INGREDIENT (id, name) VALUES (default, '두부');
INSERT INTO INGREDIENT (id, name) VALUES (default, '호박');
INSERT INTO INGREDIENT (id, name) VALUES (default, '찹쌀');
INSERT INTO INGREDIENT (id, name) VALUES (default, '설탕');
INSERT INTO INGREDIENT (id, name) VALUES (default, '계란');
INSERT INTO INGREDIENT (id, name) VALUES (default, '소금');
INSERT INTO INGREDIENT (id, name) VALUES (default, '후추');
INSERT INTO INGREDIENT (id, name) VALUES (default, '대파');
INSERT INTO INGREDIENT (id, name) VALUES (default, '당면');
INSERT INTO INGREDIENT (id, name) VALUES (default, '시금치');
INSERT INTO INGREDIENT (id, name) VALUES (default, '참기름');
INSERT INTO INGREDIENT (id, name) VALUES (default, '등심 스테이크');
INSERT INTO INGREDIENT (id, name) VALUES (default, '버터');
INSERT INTO INGREDIENT (id, name) VALUES (default, '로즈마리');
INSERT INTO INGREDIENT (id, name) VALUES (default, '레몬');
INSERT INTO INGREDIENT (id, name) VALUES (default, '물');

INSERT INTO INGREDIENT (id, name) VALUES (default, '양파');
INSERT INTO INGREDIENT (id, name) VALUES (default, '마늘');
INSERT INTO INGREDIENT (id, name) VALUES (default, '당근');
INSERT INTO INGREDIENT (id, name) VALUES (default, '파');
INSERT INTO INGREDIENT (id, name) VALUES (default, '고추');
INSERT INTO INGREDIENT (id, name) VALUES (default, '감자');
INSERT INTO INGREDIENT (id, name) VALUES (default, '토마토');
INSERT INTO INGREDIENT (id, name) VALUES (default, '오이');
INSERT INTO INGREDIENT (id, name) VALUES (default, '양배추');

-- 레시피-재료 연결
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 1 ,1);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 2 ,2);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 3 ,3);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 3 ,4);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 3 ,5);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 4 ,6);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 4 ,7);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 4 ,8);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 5 ,9);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 5 ,10);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 5 ,11);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 6 ,12);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 6 ,13);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 6 ,14);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 7 ,15);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 8 ,16);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 8 ,17);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 8 ,18);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 9 ,19);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 9 ,20);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 10 ,21);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 10 ,22);

-- 1번 레시피 양파,마늘
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 11 ,23);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 11 ,24);
-- 2번 레시피 마늘,당근
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 12 ,24);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 12 ,25);
-- 3번 레시피 당근,파
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 13 ,25);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 13 ,26);
-- 4번 레시피 파,고추
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 14 ,26);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 14 ,27);
-- 5번 레시피 양파,마늘,감자
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 15 ,23);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 15 ,24);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 15 ,28);
-- 6번 레시피 마늘,당근, 토마토
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 16 ,23);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 16 ,24);
INSERT INTO RECIPE_INGREDIENT (id, recipe_id, ingredient_id) VALUES (default, 16 ,29);
