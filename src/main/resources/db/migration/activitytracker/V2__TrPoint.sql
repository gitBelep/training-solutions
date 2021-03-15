CREATE TABLE `track_point` (
	`tr_id` INT(5) NOT NULL AUTO_INCREMENT,
	`a_id` BIGINT(20) Unsigned NOT NULL,
	`tr_time` DATETIME NOT NULL,
	`tr_lat` DECIMAL(10,7) NOT NULL,
	`tr_lon` DECIMAL(10,7) NOT NULL,
	PRIMARY KEY (`tr_id`) USING BTREE,
	INDEX `neve` (`a_id`) USING BTREE,
	CONSTRAINT `neve` FOREIGN KEY (`a_id`)
REFERENCES `activitytracker`.`activities` (`id`)
ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
;
