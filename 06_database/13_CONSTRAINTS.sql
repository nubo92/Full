/* CONSTRAINTS(제약 조건) */

# NOT NULL
-- NULL 값 허용하지 않음

CREATE TABLE IF NOT EXISTS user_notnull(
	user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3)
) ENGINE=INNODB;

INSERT INTO user_notnull VALUE(1, 'user01', 'pass01', '남');

SELECT * FROM user_notnull;

INSERT INTO user_notnull VALUE(2, 'user02', null, '여');

# UNIQUE
-- 중복값 허용하지 않음
CREATE TABLE IF NOT EXISTS user_unique(
	user_no INT NOT NULL UNIQUE,		-- 회원번호는 중복될 수 없다.
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    UNIQUE (user_id)		-- id도 중복될 수 없다. (테이블 레벨 선언 방식)
) ENGINE=INNODB;

INSERT INTO user_unique VALUE(1, 'user01', 'pass01', '남');
INSERT INTO user_unique VALUE(1, 'user02', 'pass02', '여');		-- 에러발생

INSERT INTO user_unique VALUE(2, 'user01', 'pass02', '남');
INSERT INTO user_unique VALUE(3, 'user03', 'pass01', '남');

SELECT * FROM user_unique;

# PRIMARY KEY
-- 테이블에서 한 행의 정보를 찾기 위해 사용 할 컬럼을 의미한다.
-- 테이블에 대한 식별자 역활을 한다. (한 행씩 구분하는 역활)
-- NOT NULL + UNIQUE 제약조건의 의미
CREATE TABLE IF NOT EXISTS user_primarykey(
	-- user_no INT PRIMARY KEY,		-- 이 칼럼이 이 테이블의 대표 식별자
    user_no INT,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    gender VARCHAR(3),
    PRIMARY KEY(user_no)		-- 테이블 레벨 성정 가능
) ENGINE=INNODB;

-- 1. NULL 값 시도 (NOT NULL 위반)
INSERT INTO user_primarykey VALUE( NULL, 'user01', 'pass01', '남');

-- 2. 중복 값 시도 (UNIQUE 위반)
INSERT INTO user_primarykey VALUE(1, 'user01', 'pass01', '남');
INSERT INTO user_primarykey VALUE(1, 'user02', 'pass02', '여');

# FOREIGN KEY
-- 참조된 다른 테이블에서 제공하는 값만 사용할 수 있다.
-- 두 테이블을 연결하고 관계를 맺어준다.
-- 제공되는 값 외에는 NULL을 사용할 수 있다.

CREATE TABLE IF NOT EXISTS user_grade (
	grade_code INT PRIMARY KEY,
    grade_name VARCHAR(255) NOT NULL
)ENGINE=INNODB;

INSERT INTO user_grade VALUE (10, '일반회원'), (20, '우수회원'), (30, '특별회원');

SELECT * FROM user_grade;

CREATE TABLE IF NOT EXISTS user_foregnkey1 (
	user_no INT PRIMARY KEY,
    grade_code INT,
    -- 이 테이블의 grade_code 는 user_grade 테이블의 grade_code를 참조한다.
    FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
)ENGINE=INNODB;

INSERT INTO user_foregnkey1 VALUE(1, 10);

-- 참조 컬러에 없는 값을 적용하면 에러 발생
INSERT INTO user_foregnkey1 VALUE(2, 50);

# ON UPDATE / ON DELETE 옵션
-- SET NULL : 부모(user_grade)가 바뀌거나 사라지면, 해당 값을 NULL로 바꾼다.
-- CASCADE : 부모가 바뀌면 자식도 따라 바뀌고, 부모가 사라지면 자식도 함께 사라진다.

CREATE TABLE IF NOT EXISTS user_foregnkey2 (
	user_no INT PRIMARY KEY,
    grade_code INT,
    -- 이 테이블의 grade_code 는 user_grade 테이블의 grade_code를 참조한다.
    FOREIGN KEY(grade_code) REFERENCES user_grade(grade_code)
    ON UPDATE SET NULL
    ON DELETE SET NULL
)ENGINE=INNODB;

INSERT INTO user_foregnkey2 VALUE(1, 10), (2, 20), (3, 30);
SELECT * FROM user_foregnkey2;

DROP TABLE IF EXISTS user_foregnkey1;

-- 부모 테이블 의 grade_code 수정
UPDATE user_grade
SET grade_code = 40
WHERE grade_code = 10;

# CHECK
-- 들어올 수 있는 값의 범위나 조건을 직접 지정
CREATE TABLE IF NOT EXISTS user_check(
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3) CHECK (gender IN ('남', '여')),
    age INT CHECK (age >= 19)
)ENGINE=INNODB;

INSERT INTO user_check VALUE (NULL, '홍길동', '남', 28);

SELECT * FROM user_check; 

-- check 제약조건 위반
INSERT INTO user_check VALUE (NULL, '유관순', '여성', 27);
INSERT INTO user_check VALUE (NULL, '판다', '여', 18);

# DEFAULT
-- INSERT시 특정 컬럼에 값을 주지 않으면, 자동으로 채워질 기본값을 지정한다.

CREATE TABLE IF NOT EXISTS tbl_country (
	country_code INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) DEFAULT '한국',
    add_day DATE DEFAULT (current_date),
    add_time DATETIME DEFAULT (current_time)
)ENGINE=INNODB;

INSERT INTO tbl_country VALUES(null, default, default, default);

-- INSERT 시 생략한 컬럼도 자동으로 default 값으로 설정 된다.
INSERT INTO tbl_country (country_code, country_name) VALUES(null, '미국');

SELECT * FROM tbl_country; 






