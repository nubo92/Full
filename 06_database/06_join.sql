# JOIN

-- 1. 컬럼 별칭
SELECT
	menu_name AS '메뉴 이름',		-- 띄어쓰기가 있으면 따옴표 사용
    menu_price price			-- 간단하면 AS와 따옴표 생략 가능
FROM
	tbl_menu;
    
-- 2. 테이블 별칭 (JOIN에서 필수)
-- tbl_manu 테이블에 'a'라는 별칭을 붙여줌
SELECT 
	a.menu_name,
    a.menu_price
FROM
	tbl_menu AS a;		-- AS 생략 가능
    
-- INNER JOIN - 교집합 (가장 기본적인 조인, INNER 키워드 생략 가능)
SELECT
	a.menu_name,
    b.category_name
FROM
	tbl_menu a
JOIN tbl_category b ON a.category_code = b.category_code;

-- OUTER JOIN ( LEFT / RIGTH )
-- LEFT JOIN : JOIN문을 기준으로 왼쪽 테이블의 데이터는 모두 보여주고,
		    -- 오른쪽 테이블에서 짝이 맞는 데이터가 없으면 'NULL'로 채워서 보여준다.
SELECT 
	a.category_name,
    b.menu_name
FROM
	tbl_category a   -- 왼쪽 테이블
LEFT JOIN tbl_menu b ON a.category_code = b.category_code;

-- SELF JOIN (같은 테이블 안에서 행과 행의 관계가 있는 경우, 그걸 연결해서 보고 싶을 때 셀프조인을 할 수 있다.)
SELECT 
	a.category_name AS '하위 카테고리',
    a.ref_category_code,
    b.category_name AS '상위 카테고리',
    b.category_name
FROM
	tbl_category a    -- '하위' 역활을 할 a 테이블
JOIN tbl_category b ON a.ref_category_code = b.ref_category_code;	-- 상위 역활을 할 b 테이블
