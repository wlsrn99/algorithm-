# 쿼리를 작성하는 목표, 확인할 지표 : 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :CAR_RENTAL_COMPANY_CAR
# Join KEY :
# 데이터 특징 :소수 첫 번째 자리에서 반올림

SELECT
 ROUND(AVG(DAILY_FEE),0) AS AVERAGE_FEE
FROM 
 CAR_RENTAL_COMPANY_CAR
WHERE
 CAR_TYPE = "SUV"

