SELECT
    -- DATE_FORMAT(YM, '%Y') AS YEAR,    -- 문자열 출력 (오답)
    -- LEFT(YM, 4) AS YEAR,              -- 문자열 출력 (오답)
    YEAR(YM) AS YEAR,                   -- 정수 출력 (정답)
    ROUND(AVG(PM_VAL1), 2) AS "PM10",
    ROUND(AVG(PM_VAL2), 2) AS "PM2.5"
FROM 
 AIR_POLLUTION
WHERE 
 LOCATION2 = '수원'
GROUP BY 
 YEAR
ORDER BY 
 YEAR