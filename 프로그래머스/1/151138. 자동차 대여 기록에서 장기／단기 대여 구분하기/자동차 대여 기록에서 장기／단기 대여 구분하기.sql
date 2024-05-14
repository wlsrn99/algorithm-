# 쿼리를 작성하는 목표, 확인할 지표 : 2022년 9월에 속하는 대여 기록에 대해서 / 30일 이상이면 '장기 대여'
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :
# Join KEY :
# 데이터 특징 :

SELECT
 history_id AS HISTORY_ID,
 car_id AS CAR_ID,  
 DATE_FORMAT(start_date, "%Y-%m-%d") AS START_DATE,
 DATE_FORMAT(end_date, "%Y-%m-%d") AS END_DATE,
 if(DATEDIFF(end_date, start_date) >= 29, "장기 대여", "단기 대여") AS RENT_TYPE
FROM
 CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
 DATE_FORMAT(START_DATE, "%Y-%m") = "2022-09"
ORDER BY
 HISTORY_ID DESC;