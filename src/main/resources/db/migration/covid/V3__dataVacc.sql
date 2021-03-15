INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Gustavus Wassung', '3000',	96, 'gwassunge@yolasite.com', '123456922',0);
INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Kirsteni Antuoni', '3000', 12, 'kantuonif@mozilla.com', '123456939',0);
INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ( 'Harlie Samwyse', '3000', 37, 'hsamwyse6@bloomberg.com', '123456843', 0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Angie O Mara', '3000', 59, 'ao7@infoseek.co.jp', '123456850',0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Scarface Shermore', '3000',	42, 'sshermore8@businessinsider.com', '123456867',0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Valerie Pummell', '2000',	27, 'vpummell9@army.mil', '123456874',0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Eustacia Foux', '2000',	30, 'efouxa@harvard.edu', '123456881',0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Jammie Seivertsen', '2000', 71, 'jseivertsenb@ox.ac.uk', '123456898',0);
 INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Jasun Tennick', '2000',	55, 'jtennickc@merriam-webster.com', '123456908',0);
INSERT INTO citizens (`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`)
VALUES ('Joanne Rikel', '2000', 32,	'jrikeld@google.co.uk', '123456915',0);

UPDATE `covid`.`citizens`
SET `number_of_vaccination`='1', `last_vaccination`='2021-01-08 15:43:38'
WHERE  `citizen_id`=1;
UPDATE `covid`.`citizens`
SET `number_of_vaccination`='2', `last_vaccination`='2021-01-08 15:43:38'
WHERE  `citizen_id`=2;

INSERT INTO `covid`.`vaccinations`
(`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`)
VALUES ('1', '2021-01-08 15:47:59', 'OK', '-', 'Astra');
INSERT INTO `covid`.`vaccinations`
(`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`)
VALUES ('2', '2020-11-08 15:47:59', 'OK', '-', 'szputnyik');
INSERT INTO `covid`.`vaccinations`
(`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`)
VALUES ('2', '2021-01-08 15:47:59', 'OK', '-', 'szputnyik');