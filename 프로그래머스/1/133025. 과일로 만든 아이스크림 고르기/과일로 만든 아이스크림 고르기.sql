# 쿼리를 작성하는 목표, 확인할 지표 : 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :FIRST_HALF
# Join KEY :FLAVOR
# 데이터 특징 :총주문량이 3,000보다 높으면서

SELECT
 ICECREAM_INFO.FLAVOR
FROM 
 FIRST_HALF
LEFT JOIN
 ICECREAM_INFO
ON 
 FIRST_HALF.FLAVOR = ICECREAM_INFO.FLAVOR
WHERE
 TOTAL_ORDER > 3000
AND
 INGREDIENT_TYPE = 	"fruit_based"
ORDER BY
 TOTAL_ORDER DESC