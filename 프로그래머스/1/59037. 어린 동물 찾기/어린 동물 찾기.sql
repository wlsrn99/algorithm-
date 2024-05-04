# 쿼리를 작성하는 목표, 확인할 지표 : 젊은 동물의 아이디와 이름, 아이디 순 정렬
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :ANIMAL_INS
# Join KEY :
# 데이터 특징 : INTAKE_CONDITION이 Aged가 아닌 경우 

SELECT
 ANIMAL_ID,
 NAME
FROM 
 ANIMAL_INS
WHERE
 INTAKE_CONDITION != "Aged"
ORDER BY
 ANIMAL_ID