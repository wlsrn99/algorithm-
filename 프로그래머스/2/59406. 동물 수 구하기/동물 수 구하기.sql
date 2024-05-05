# 쿼리를 작성하는 목표, 확인할 지표 : 동물 보호소에 동물이 몇 마리 들어왔는지 조회
# 쿼리 계산 방법 : COUNT
# 데이터의 기간 : x
# 사용할 테이블 :ANIMAL_INS
# Join KEY : x
# 데이터 특징 :

SELECT
 COUNT(ANIMAL_ID) AS count
FROM 
 ANIMAL_INS

