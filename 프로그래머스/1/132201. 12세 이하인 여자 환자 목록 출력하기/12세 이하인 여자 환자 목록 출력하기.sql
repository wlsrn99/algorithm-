# 쿼리를 작성하는 목표, 확인할 지표 : 12세 이하인 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :PATIENT
# Join KEY :
# 데이터 특징 :전화번호가 없는 경우 'NONE' / 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬

SELECT
 PT_NAME,
 PT_NO,
 GEND_CD,
 AGE,
 IF (TLNO IS NOT NULL, TLNO, "NONE") AS TLNO
FROM 
 PATIENT
WHERE
 AGE <= 12
 AND
 GEND_CD = "W"
ORDER BY
 AGE DESC, PT_NAME
