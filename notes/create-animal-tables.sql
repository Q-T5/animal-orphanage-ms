-- create a new schema and use it to house the tables and relations 
DROP SCHEMA IF EXISTS `impala_sanctuary_system_schema`;
CREATE SCHEMA `impala_sanctuary_system_schema`;
USE `impala_sanctuary_system_schema`;

-- create the adoption_detail table
DROP TABLE IF EXISTS `animal_adoption_detail`;
CREATE TABLE `animal_adoption_detail` (
	-- this field is auto generated and it depends on the animal_id field of the animal_detail table
    `animal_id` int NOT NULL AUTO_INCREMENT, 
    -- this is the date the animal was adopted from the orphanage
    `date_adopted` date,
    `adoptee_name` varchar(128),
    `contact_number` varchar(24),
    `residential_location` varchar(128),
    
    -- the PK for this table
    CONSTRAINT PRIMARY KEY(`animal_id`)
);
-- this always ensures the IDs start from 100
ALTER TABLE `animal_adoption_detail` AUTO_INCREMENT=100;

-- create the animal_detail table to store basic animal details
DROP TABLE IF EXISTS `animal_basic_detail`;
CREATE TABLE `animal_basic_detail` (
    `animal_id` int NOT NULL AUTO_INCREMENT,
    `common_name` varchar(128) NOT NULL,
    `where_found` varchar(256) NULL,
    `age_years` int(3) NULL,
    `date_brought` date NOT NULL,
    -- this column will be the foreign key as well as our join column
    `fk_adoption_detail_id` int NOT NULL,
    CONSTRAINT PRIMARY KEY(`animal_id`),
    CONSTRAINT FOREIGN KEY(`fk_adoption_detail_id`) REFERENCES `animal_adoption_detail`(`animal_id`)
    
    -- delete operations and update operations affect the animal_adoption_detail table
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- alter the `id` column to start AUTO_INCREMENT from 100
ALTER TABLE `animal_basic_detail` AUTO_INCREMENT=100;

