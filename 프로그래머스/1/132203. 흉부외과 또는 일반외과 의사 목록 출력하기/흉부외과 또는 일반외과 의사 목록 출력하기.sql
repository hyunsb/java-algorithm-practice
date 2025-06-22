-- 코드를 입력하세요
SELECT 
    d.DR_NAME,
    d.DR_ID,
    d.MCDP_CD,
    DATE_FORMAT(d.HIRE_YMD, '%Y-%m-%d')
FROM
    DOCTOR d
WHERE
    d.MCDP_CD IN ('CS', 'GS')
ORDER BY 
    d.HIRE_YMD desc, d.DR_NAME asc