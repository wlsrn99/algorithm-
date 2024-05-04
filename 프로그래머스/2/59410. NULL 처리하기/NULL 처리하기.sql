# 쿼리를 작성하는 목표, 확인할 지표 : 동물의 생물 종, 이름, 성별, 중성화 여부를 아이디 순으로 조회
# 쿼리 계산 방법 : WHERE
# 데이터의 기간 : x
# 사용할 테이블 : ANIMAL_INS
# Join KEY : x
# 데이터 특징 : x

SELECT
 ANIMAL_TYPE,
 IF (NAME IS NULL, "No name", NAME) AS NAME,
 SEX_UPON_INTAKE
FROM 
 ANIMAL_INS
ORDER BY
 ANIMAL_ID
