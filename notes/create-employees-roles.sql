-- use the existing animal_orphanage_tracker schema
USE `impala_animal_system_schema`;

-- create the employee_details table
DROP TABLE IF EXISTS `staff_detail`;
CREATE TABLE `staff_detail` (
	`staff_id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(128) NOT NULL,
    `last_name` varchar(128) NULL,
    `password` varchar(128) NOT NULL,
    `account_status` varchar(64) NOT NULL DEFAULT 'active',
    `recovery_phrase` varchar(128) NOT NULL,
    CONSTRAINT PRIMARY KEY (`staff_id`)
);

-- create the employee_roles table
DROP TABLE IF EXISTS `staff_roles`;
CREATE TABLE `staff_roles` (
	`role_id` int(2) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(64) NOT NULL DEFAULT 'ROLE_EDITOR',
    CONSTRAINT PRIMARY KEY(`role_id`)
);

-- we will create another table to join the first two(join table)- acting as a mapper
DROP TABLE IF EXISTS `staff_detail_role`;
CREATE TABLE `staff_detail_role` (
	`staff_id` int NOT NULL,
    `role_id` int NOT NULL,
    CONSTRAINT PRIMARY KEY(`staff_id`, `role_id`),
    CONSTRAINT FOREIGN KEY(`staff_id`) REFERENCES `staff_detail`(`staff_id`)
    ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT FOREIGN KEY(`role_id`) REFERENCES `staff_roles` (`role_id`)
    ON DELETE CASCADE ON UPDATE CASCADE
);
