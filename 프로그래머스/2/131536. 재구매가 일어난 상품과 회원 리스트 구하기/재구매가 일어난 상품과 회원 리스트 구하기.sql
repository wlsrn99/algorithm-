# 쿼리를 작성하는 목표, 확인할 지표 : 재구매한 회원 ID와 재구매한 상품 ID를 출력
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 : ONLINE_SALE
# Join KEY :
# 데이터 특징 : 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬

SELECT
 custom.USER_ID,
 custom.PRODUCT_ID
FROM
(
SELECT
 USER_ID,
 PRODUCT_ID,
 COUNT(USER_ID) AS cnt
FROM 
 ONLINE_SALE
GROUP BY
 USER_ID, PRODUCT_ID
ORDER BY
 USER_ID
 ) custom
WHERE
 (custom.cnt >= 2)
ORDER BY
 USER_ID, PRODUCT_ID DESC