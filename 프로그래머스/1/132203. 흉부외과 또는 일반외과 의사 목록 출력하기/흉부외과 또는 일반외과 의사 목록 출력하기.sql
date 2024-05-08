# 쿼리를 작성하는 목표, 확인할 지표 : 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회
# 쿼리 계산 방법 :
# 데이터의 기간 :
# 사용할 테이블 :DOCTOR
# Join KEY :
# 데이터 특징 :고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬

SELECT
 DR_NAME,
 DR_ID,
 MCDP_CD,
 DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") AS HIRE_YMD
FROM 
 DOCTOR
WHERE
 (MCDP_CD = "CS")
 OR
 (MCDP_CD = "GS")
ORDER BY
 HIRE_YMD DESC, DR_NAME