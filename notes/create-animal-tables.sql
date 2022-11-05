-- create a new schema and use it to build the tables and relations 
DROP SCHEMA IF EXISTS `animal_orphanage_tracker`;
CREATE SCHEMA `animal_orphanage_tracker`;
USE `animal_orphanage_tracker`;

-- create the animal_detail table
DROP TABLE IF EXISTS `animal_detail`;
CREATE TABLE `animal_detail` (
	-- this field is auto generated and it depends on the animal_id field of the animal_detail table
    `animal_id` int NOT NULL AUTO_INCREMENT, 
    `date_brought` date NOT NULL,
    `date_adopted` date,
    `adoptee_name` varchar(128),
    `contact_number` varchar(24),
    `residential_location` varchar(128),
    
    CONSTRAINT PRIMARY KEY(`animal_id`)
);
ALTER TABLE `animal_detail` AUTO_INCREMENT=100;

-- create the animal_detail table
DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
    `animal_id` int NOT NULL AUTO_INCREMENT,
    `pet_name` varchar(128),
    `common_name` varchar(128) NOT NULL,
    `age_years` int(3) NOT NULL,
    -- this column will be the foreign key as well as our join column
    `fk_animal_detail_id` int DEFAULT NULL,
    CONSTRAINT PRIMARY KEY(`animal_id`),
    
    -- this foreign key will act as our join column Hibernate-wise
    CONSTRAINT FOREIGN KEY(`fk_animal_detail_id`) REFERENCES `animal_detail`(`animal_id`)
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- alter the `id` column to start AUTO_INCREMENT from 100
ALTER TABLE `animal` AUTO_INCREMENT=100;

