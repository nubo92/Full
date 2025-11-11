# ORDER BY
-- SELECT문의 가장 마지막에 위치하며, 결과 집합을 하나의 열로 정렬

-- 오름차순 정렬
SELECT 
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu
ORDER BY
	menu_price;  -- 오름차순이 기본 설정
    -- menu_price ASC;  -- ASC는 오름차순을 의미 (생략 가능)

-- 내림차순 정렬    
SELECT 
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu
ORDER BY
	menu_price DESC,  -- DESC는 내림차순 (생략 불가능)
    menu_name ASC;		-- 2차 기준 : 가격이 같다면, 이름 오름차순으로
    
-- 연산 결과로 정렬(보통 별칭을 사용한다.)  AS
SELECT 
	menu_code,
    menu_name,
    menu_code * menu_price AS calculated_value
FROM
	tbl_menu
ORDER BY
	calculated_value DESC;
    
-- FIELD(컬럼, 첫번째, 두번째, ...) : 컴럼 값이 모곡의 몇 번째에 있는지 숫자로 알려준다.
SELECT FIELD('B', 'A', 'B', 'C');

-- 'N'을 1tnsdn1, 'Y'를 2순위로 정렬
SELECT
	menu_name,
    orderable_status
FROM
	tbl_menu
ORDER BY FIELD(orderable_status, 'N', 'Y');		-- N은 1, Y는 2가 되어 이 결과를 기준으로 오름차순 정렬

-- null 값이 있는 컬럼이 기준 ( MySQL은 null을 가장 작은 값으로 취급한다.)
SELECT 
	category_code,
    category_name,
    ref_category_code
FROM
	tbl_category
ORDER BY
	ref_category_code IS NULL; 		-- null = true( 1 ) / !null = false( 0 )
    
    -- 내림차순 시 NULL을 처음으로 ( IS NULL DESC)
    SELECT 
	category_code,
    category_name,
    ref_category_code
FROM
	tbl_category
ORDER BY
	ref_category_code IS NULL DESC,
    ref_category_code DESC;