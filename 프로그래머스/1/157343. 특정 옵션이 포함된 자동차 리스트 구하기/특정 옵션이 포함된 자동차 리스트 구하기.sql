# 쿼리를 작성하는 목표, 확인할 지표 : '네비게이션' 옵션이 포함된 자동차 리스트
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :CAR_RENTAL_COMPANY_CAR
# Join KEY :
# 데이터 특징 : 자동차 ID를 기준으로 내림차순 정렬

SELECT
 *
FROM 
 CAR_RENTAL_COMPANY_CAR
WHERE
 OPTIONS LIKE "%네비게이션%"
ORDER BY
 CAR_ID DESC