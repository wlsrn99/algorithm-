# 쿼리를 작성하는 목표, 확인할 지표 : 이름이 있는 동물의 ID를 조회 후 오름차순 정렬
# 쿼리 계산 방법 : WHERE
# 데이터의 기간 : x
# 사용할 테이블 : ANIMAL_INS
# Join KEY : x
# 데이터 특징 : VARCHAR, NOT NULL

SELECT
 ANIMAL_ID
FROM 
 ANIMAL_INS
WHERE
 NAME IS NOT NULL
ORDER BY 
 ANIMAL_ID