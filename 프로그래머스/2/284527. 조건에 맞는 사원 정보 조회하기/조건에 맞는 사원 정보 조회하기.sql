SELECT 
 custom.score,
 custom.emp_no,
 HR_EMPLOYEES.emp_name,
 HR_EMPLOYEES.position,
 HR_EMPLOYEES.email
FROM
 HR_EMPLOYEES
LEFT JOIN
 (SELECT
 emp_no,
 SUM(score) as score
FROM
 HR_GRADE
GROUP BY
 EMP_NO
  ) as custom
ON
 custom.emp_no = HR_EMPLOYEES.emp_no
ORDER BY
 custom.score DESC
LIMIT 
 1

