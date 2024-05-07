# 쿼리를 작성하는 목표, 확인할 지표 : 식품공장의 공장 ID, 공장 이름, 주소를 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 : FOOD_FACTORY
# Join KEY :
# 데이터 특징 :공장 ID를 기준으로 오름차순 정렬

SELECT
 FACTORY_ID,
 FACTORY_NAME,
 ADDRESS
FROM 
 FOOD_FACTORY
WHERE
 ADDRESS like "%강원도%"
ORDER BY
 FACTORY_ID
 