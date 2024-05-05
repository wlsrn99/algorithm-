# 쿼리를 작성하는 목표, 확인할 지표 : 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회, 
#                             이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나
# 쿼리 계산 방법 : GROUP BY
# 데이터의 기간 : x
# 사용할 테이블 : ANIMAL_INS
# Join KEY : x
# 데이터 특징 :

SELECT
 COUNT(DISTINCT NAME) AS count
FROM 
 ANIMAL_INS
WHERE
 NAME IS NOT NULL



