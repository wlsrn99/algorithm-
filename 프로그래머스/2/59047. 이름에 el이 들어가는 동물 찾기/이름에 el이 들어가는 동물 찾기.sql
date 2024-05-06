# 쿼리를 작성하는 목표, 확인할 지표 : 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회하는 SQL문
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 : ANIMAL_INS
# Join KEY :
# 데이터 특징 :이름 순으로 조회

SELECT
 ANIMAL_ID,
 NAME
FROM 
 ANIMAL_INS
WHERE
 NAME LIKE CONCAT("%", "el", "%")
 AND
 ANIMAL_TYPE = "Dog"
ORDER BY
 NAME
