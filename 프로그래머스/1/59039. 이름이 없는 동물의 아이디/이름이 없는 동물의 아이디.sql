# 쿼리를 작성하는 목표, 확인할 지표 : 이름이 없는 채로 들어온 동물의 ID를 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :ANIMAL_INS
# Join KEY :
# 데이터 특징 : ID는 오름차순 정렬

SELECT
 ANIMAL_ID
FROM 
 ANIMAL_INS
WHERE
 NAME IS NULL
ORDER BY
 ANIMAL_ID