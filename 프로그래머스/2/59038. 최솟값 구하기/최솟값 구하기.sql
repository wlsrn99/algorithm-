# 쿼리를 작성하는 목표, 확인할 지표 : 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :ANIMAL_INS
# Join KEY :
# 데이터 특징 :

SELECT
 DATETIME AS 시간
FROM 
 ANIMAL_INS
ORDER BY
 DATETIME 
LIMIT
 1

