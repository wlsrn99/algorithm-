# 쿼리를 작성하는 목표, 확인할 지표 : 2021년에 출판된 '인문' 카테고리에 속하는 도서 리스트
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :BOOK
# Join KEY :
# 데이터 특징 :출판일을 기준으로 오름차순 정렬

SELECT
 BOOK_ID,
 DATE_FORMAT(PUBLISHED_DATE, "%Y-%m-%d") AS PUBLISHED_DATE
FROM 
 BOOK
WHERE
 EXTRACT(YEAR FROM PUBLISHED_DATE) = 2021
 AND
 CATEGORY = "인문"
ORDER BY
 PUBLISHED_DATE 
