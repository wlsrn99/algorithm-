# 쿼리를 작성하는 목표, 확인할 지표 : 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :
# Join KEY :
# 데이터 특징 :고양이를 개보다 먼저 조회

SELECT
 ANIMAL_TYPE,
 COUNT(ANIMAL_ID) AS count
FROM 
 ANIMAL_INS
GROUP BY
 ANIMAL_TYPE
ORDER BY
 ANIMAL_TYPE
