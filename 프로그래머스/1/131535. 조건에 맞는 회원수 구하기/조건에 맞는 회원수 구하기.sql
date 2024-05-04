# 쿼리를 작성하는 목표, 확인할 지표 : 나이가 20세 이상 29세 이하인 회원이 몇 명인지,  2021년에 가입한 회원 중
# 쿼리 계산 방법 : COUNT
# 데이터의 기간 : 2021년에 가입
# 사용할 테이블 : USER_INFO
# Join KEY : x
# 데이터 특징 :DATE

SELECT
 COUNT(USER_ID) AS USERS
FROM
 USER_INFO
WHERE
 (AGE BETWEEN 20 AND 29)
 AND
 EXTRACT(YEAR FROM JOINED) = 2021


 