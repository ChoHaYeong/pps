-- 이름 없는 동물의 아이디
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NULL

-- 이름 있는 동물의 아이디
SELECT ANIMAL_ID FROM ANIMAL_INS WHERE NAME IS NOT NULL ORDER BY animal_ID

-- null 처리하기
SELECT ANIMAL_TYPE, 
CASE 
    WHEN NAME IS NULL 
    THEN 'No name' 
    ELSE NAME 
END NAME, 
SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;