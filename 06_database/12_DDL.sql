/* DDL (Data Definition Language) */
-- 데이터 정의 언어 (CREATE, ALTER, DROP)

# CREATE
-- 테이블 생성을 위한 구문
/* 
CREATE TABLE 테이블명(
	컬럼명 데이터타입(길이) [제약조건],
    컬럼명 데이터타입(길이) [제약조건],
    ...
*/

-- IF NOT EXISTE : 존재하지 않을때만 생성하기 위한 구문
CREATE TABLE IF NOT EXISTS tb1(		
	pk INT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

-- 테이블 타입, 설정 확인
DESCRIBE tb1;

INSERT INTO tb1 VALUE(1, 10, 'Y');

SELECT * FROM tb1;

-- AUTO_INCREMENT
-- INSERT시 PRIMARY KET에 해당하는 컬럼에 자동으로 번호를 발생(중복되지 않게)시켜 저장할 수 있다.
-- tb2 생성
CREATE TABLE IF NOT EXISTS tb2(		
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

DESCRIBE tb2;

-- pk값에 NULL을 주면 자동으로 번호가 채워진다.
INSERT INTO tb2 VALUE(null, 10, 'Y');
INSERT INTO tb2 VALUE(null, 20, 'N');

SELECT * FROM tb2;

# ALTER
-- 테이블에 추가/변경/수정/삭제하는 모든 것은 ALTER  명령어를 사용해 적용한다.

-- tb2 테이블에 'col2' 정수형 컬럼 추가
ALTER TABLE tb2
ADD col2 INT NOT NULL;

DESCRIBE tb2;

-- 'col2' 컬럼 삭제
ALTER TABLE tb2
DROP COLUMN col2;

-- 'fk' 컬럼 이름과 데이터 형식, 제약조건 바꾸기
ALTER TABLE tb2
CHANGE COLUMN fk change_fk INT NOT NULL;

ALTER TABLE tb2
DROP PRIMARY KEY; -- 에러 발생 (auto increment 걸려있어서!!!)

-- MODIFY : 컬럼의 정의 변경
ALTER TABLE tb2
MODIFY pk INT;

DESCRIBE tb2;

-- 이제 PRIMARY KEY 삭제 가능
ALTER TABLE tb2
DROP PRIMARY KEY;

-- 다시 제약조건 추가
ALTER TABLE tb2 ADD PRIMARY KEY(pk);

# DROP
-- 테이블의 구조와 데이터를 영구적으로 삭제(되돌릴 수 없다)
CREATE TABLE IF NOT EXISTS tb3(		
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

-- tb3 삭제. IN EXISTS를 붙이면 테이블이 없어도 에러가 나지 않음
DROP TABLE IF EXISTS tb3;	-- 콤마를 이용하여 여러 테이블도 삭제 가능 DROP TABLE table1, table2;

# TRUNCATE
-- 테이블 내용물만 비우고 초기화하기(구조만 넘겨두고, 데이터만 깨끗하게 비우고 싶을 때 사용하면 효율적)
CREATE TABLE IF NOT EXISTS tb4(		
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

INSERT INTO tb4 VALUE(NULL, 10, 'Y'), (NULL, 20, 'N');

SELECT * FROM tb4;
DESCRIBE tb4;

-- 테이블 초기화
TRUNCATE TABLE tb4;

-- 다시 데이터를 넣으면 pk가 1부터 시작한다.
INSERT INTO tb4 VALUE(NULL, 10, 'Y'), (NULL, 20, 'N');

SELECT * FROM tb4;



