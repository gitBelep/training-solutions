USE covid;

CREATE TABLE `cities` (
 `city_id` BIGINT(5) NOT NULL AUTO_INCREMENT,
 `zip` VARCHAR(4) NOT NULL COLLATE 'utf8_hungarian_ci',
 `city` VARCHAR(40) NOT NULL COLLATE 'utf8_hungarian_ci',
 `city_part` VARCHAR(40),
 PRIMARY KEY (`city_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB;

INSERT INTO `covid`.`cities` (`zip`, `city`) VALUES ('2400', 'Izé');
INSERT INTO `covid`.`cities` (`zip`, `city`) VALUES ('2040', 'Bármi');
INSERT INTO `covid`.`cities` (`zip`, `city`) VALUES ('2000', 'Szentendre');
INSERT INTO `covid`.`cities` (`zip`, `city`) VALUES ('3000', 'Szivecském');