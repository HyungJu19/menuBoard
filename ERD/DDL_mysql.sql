-- 테이블삭제
DROP TABLE IF EXISTS exam_menu;
-- 생성
CREATE TABLE exam_menu
(
    mn_uid int PRIMARY KEY AUTO_INCREMENT,
    mn_name varchar(20) NOT NULL,
    mn_kind varchar(10) CHECK ( mn_kind IN ('한식', '중식', '일식')),
    mn_price int DEFAULT 0


);
-- 조회
SELECT * FROM exam_menu;


-- 샘플
INSERT INTO exam_menu (mn_name, mn_kind, mn_price) VALUES
                                                       ('삼겹살', '한식', 18000),
                                                       ('제육볶음', '한식', 7000),
                                                       ('육개장칼국수', '한식', 10000),
                                                       ('짜장면', '중식', 5000),
                                                       ('탕수육', '중식', 10000),
                                                       ('볶음밥', '중식', 9000),
                                                       ('마제소바', '일식', 11000),
                                                       ('돈부리', '일식', 10000)
;

-- 삭제 특정아이디
# DELETE FROM exam_menu WHERE mn_uid = 100;
-- 10만원이상 전부 삭제
# DELETE FROM exam_menu WHERE mn_price >= 100000;
-- 여러 메뉴 삭제
# DELETE FROM exam_menu WHERE mn_name IN ('삼겹살' ,'','');

-- 칼럼삭제
# ALTER TABLE exam_menu DROP COLUMN mn_name;
-- 여러칼럼삭제
# ALTER TABLE exam_menu DROP COLUMN mn_name, DROP COLUMN mn_price;
