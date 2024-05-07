# 쿼리를 작성하는 목표, 확인할 지표 : 경기도에 위치한 창고의 ID, 이름, 주소, 냉동시설 여부를 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :FOOD_WAREHOUSE
# Join KEY :
# 데이터 특징 :냉동시설 여부가 NULL인 경우 'N'으로 출력, 창고 ID를 기준으로 오름차순 정렬

SELECT
 WAREHOUSE_ID,
 WAREHOUSE_NAME,
 ADDRESS,
 IF(FREEZER_YN IS NULL, "N", FREEZER_YN) AS FREEZER_YN
FROM 
 FOOD_WAREHOUSE
WHERE
 WAREHOUSE_NAME LIKE "%경기%"
ORDER BY
 WAREHOUSE_ID

