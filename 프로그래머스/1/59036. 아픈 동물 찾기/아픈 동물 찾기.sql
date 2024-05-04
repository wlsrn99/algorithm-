# 쿼리를 작성하는 목표, 확인할 지표 : 아픈 동물의 아이디와 이름을 조회 , 아이디 순으로 정렬
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 : ANIMAL_INS
# Join KEY :
# 데이터 특징 : INTAKE_CONDITION 의 값이 "Sick"인 경우 

SELECT
 ANIMAL_ID,
 NAME
FROM 
 ANIMAL_INS
WHERE
 INTAKE_CONDITION = "Sick"
ORDER BY
 ANIMAL_ID