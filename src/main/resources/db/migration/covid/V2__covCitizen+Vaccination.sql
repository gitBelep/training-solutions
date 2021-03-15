USE covid
;
CREATE TABLE `citizens` (
	`citizen_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`citizen_name` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`zip` CHAR(4) NOT NULL COLLATE 'utf8_hungarian_ci',
	`age` BIGINT(20) UNSIGNED NOT NULL,
	`email` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	`taj` VARCHAR(10) NOT NULL COLLATE 'utf8_hungarian_ci',
	`number_of_vaccination` BIGINT(2) UNSIGNED NOT NULL,
	`last_vaccination` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`citizen_id`) USING BTREE,
	UNIQUE INDEX `taj` (`taj`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
;
CREATE TABLE `vaccinations` (
	`vaccination_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`citizen_id` BIGINT(10) NOT NULL,
	`vaccination_date` DATETIME NOT NULL,
	`status` VARCHAR(10) NOT NULL COLLATE 'utf8_hungarian_ci',
	`note` VARCHAR(200) NOT NULL COLLATE 'utf8_hungarian_ci',
	`vaccination_type` VARCHAR(20) NOT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`vaccination_id`) USING BTREE,
	INDEX `key_c_id` (`citizen_id`) USING BTREE,
	CONSTRAINT `key_c_id`
	FOREIGN KEY (`citizen_id`)
	REFERENCES `covid`.`citizens` (`citizen_id`)
	ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
;