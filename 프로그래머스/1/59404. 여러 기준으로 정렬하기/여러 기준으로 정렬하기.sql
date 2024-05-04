# 쿼리를 작성하는 목표, 확인할 지표 :  모든 동물의 아이디와 이름, 보호 시작일 조회, 이름 순 정렬
# 쿼리 계산 방법 :
# 데이터의 기간 : x
# 사용할 테이블 : ANIMAL_INS
# Join KEY :
# 데이터 특징 : 이름이 같은 동물 중에서는 보호를 나중에 시작한 동물을 먼저 보여줘야 한다 
SELECT 
 ANIMAL_ID, 
 NAME,
 DATETIME
FROM ANIMAL_INS 
ORDER BY NAME , DATETIME DESC;