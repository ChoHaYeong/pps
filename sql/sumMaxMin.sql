-- 최댓값 구하기
SELECT MAX(DATETIME) 
FROM ANIMAL_INS

-- 최소값 구하기
SELECT MIN(DATETIME) FROM ANIMAL_INS

-- 동물 수 구하기
SELECT (count(animal_id)) from animal_ins;

-- 중복 제거하기
SELECT count(distinct(name)) from animal_ins where name is not null

