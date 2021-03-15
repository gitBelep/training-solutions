CREATE TABLE `activities` (
 `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
 `start_time` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
 `activity_desc` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
 `activity_type` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
 PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
;

INSERT INTO activities(start_time, activity_desc, activity_type)
VALUES
('2010-01-23 10:07', 'gyalog Börzsöny', 'HIKING'),
('2020-02-23 10:07', 'Bicó Zemplén', 'BIKING'),
('2010-03-23 10:07', 'kosaraztunk', 'BASKETBALL'),
('2010-04-23 10:07', 'Bicó Zemplén', 'BIKING')
;