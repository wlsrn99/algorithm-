# 쿼리를 작성하는 목표, 확인할 지표 : 나이정보가 없는 회원이 몇 명인지 출력
# 쿼리 계산 방법 : GROUP BY
# 데이터의 기간 :  x
# 사용할 테이블 :USER_INFO
# Join KEY : x
# 데이터 특징 : INTEGER

SELECT
 COUNT(USER_ID) AS USERS 
FROM 
 USER_INFO
WHERE
 AGE IS NULL

