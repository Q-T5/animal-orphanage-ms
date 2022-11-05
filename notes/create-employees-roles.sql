-- use the existing animal_orphanage_tracker schema
USE `animal_orphanage_tracker`;

-- create the employee_details table
DROP TABLE IF EXISTS `employee_detail`;
CREATE TABLE `employee_detail` (
	`employee_id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(128) NOT NULL,
    `last_name` varchar(128) NULL,
    `password` varchar(128) NOT NULL,
    `account_state` varchar(64) NOT NULL DEFAULT 'active',
    CONSTRAINT PRIMARY KEY (`employee_id`)
);
ALTER TABLE `employee_detail` AUTO_INCREMENT = 1000;

-- create the employee_roles table
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
	`role_id` int(2) NOT NULL AUTO_INCREMENT,
    `role` varchar(64) NOT NULL DEFAULT 'ROLE_STAFF',
    CONSTRAINT PRIMARY KEY(`role_id`)
);
ALTER TABLE `role` AUTO_INCREMENT = 1;

-- we will create another table to join the first two- acting as a mapper
DROP TABLE IF EXISTS `employee_detail_role`;
CREATE TABLE `employee_detail_role` (
	`employee_id` int NOT NULL,
    `role_id` int NOT NULL,
    CONSTRAINT PRIMARY KEY(`employee_id`, `role_id`),
    CONSTRAINT FOREIGN KEY(`employee_id`) REFERENCES `employee_detail`(`employee_id`)
    ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT FOREIGN KEY(`role_id`) REFERENCES `role` (`role_id`)
    ON DELETE CASCADE ON UPDATE CASCADE
);
