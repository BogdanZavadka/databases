CREATE DATABASE IF NOT EXISTS air_bnb;
USE air_bnb;


DROP TABLE IF EXISTS `renter`;
CREATE TABLE `renter` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(35) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL
);


DROP TABLE IF EXISTS `rentee`;
CREATE TABLE `rentee` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(35) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    gender VARCHAR(5) NULL,
    birthday DATE NULL
);


DROP TABLE IF EXISTS `appartment`;
CREATE TABLE `appartment` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    area INT NULL,
    room_number INT NOT NULL,
    overall_rating INT NOT NULL,
    price_per_day INT NOT NULL,
    renter_id INT NOT NULL
);


DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    rentee_id INT NOT NULL,
    appartment_id INT NOT NULL
);


DROP TABLE IF EXISTS `appartment_adress`;
CREATE TABLE `appartment_adress` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(30) NOT NULL,
    street VARCHAR(30) NOT NULL,
	house_number INT NOT NULL,
    appartment_number INT NULL,
    appartment_id INT NOT NULL
);


DROP TABLE IF EXISTS `available_time`;
CREATE TABLE `available_time` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);


DROP TABLE IF EXISTS `appartment_time`;
CREATE TABLE `appartment_time` (
	appartment_id INT,
    available_time_id INT,
    PRIMARY KEY(appartment_id, available_time_id)
);


DROP TABLE IF EXISTS `response`;
CREATE TABLE `response` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    photo_href VARCHAR(150) NULL,
    text_response VARCHAR(300) NOT NULL,
    rating INT NOT NULL
);


DROP TABLE IF EXISTS `appartment_response`;
CREATE TABLE `appartment_response` (
	response_id INT,
    appartment_id INT,
    PRIMARY KEY(response_id, appartment_id)
);


ALTER TABLE `appartment`
	ADD CONSTRAINT fk_renter
    FOREIGN KEY (renter_id)
    REFERENCES renter(id),
    
    ADD INDEX appartment_adress_idx (overall_rating);
    

ALTER TABLE `request` 
	ADD CONSTRAINT fk_rentee
    FOREIGN KEY (rentee_id)
    REFERENCES rentee(id),
    
    ADD CONSTRAINT fk_request_appartment
    FOREIGN KEY (appartment_id)
    REFERENCES appartment(id);
    
    
ALTER TABLE `appartment_adress`
	ADD CONSTRAINT fk_adress_appartment
    FOREIGN KEY (appartment_id)
    REFERENCES appartment(id);
    

ALTER TABLE `appartment_time` 
	ADD CONSTRAINT fk_time_appartment
    FOREIGN KEY (appartment_id)
    REFERENCES appartment(id),
    
    ADD CONSTRAINT fk_time
    FOREIGN KEY (available_time)
    REFERENCES available_time(id);
    
    
ALTER TABLE `appartment_response`
	ADD CONSTRAINT fk_response
    FOREIGN KEY (response_id)
    REFERENCES response(id),
    
    ADD CONSTRAINT fk_appartment
    FOREIGN KEY (appartment)
    REFERENCES appartment(id);
    
    
ALTER TABLE `renter` 
	ADD INDEX renter_name_surname_idx (name, surname);
    

ALTER TABLE `rentee` 
	ADD INDEX rentee_name_surname_idx (name, surname);
    

INSERT INTO `renter` (name, surname, phone_number, email) VALUES 
("Sergiy", "Ivaniv", "+38348573", "qwetuyi@gmail.com"),
("Bohdan", "Bohdanov", "+3823877", "qwetuyisdfxzcz@gmail.com"),
("Anthony", "Ivaniv", "+383956773", "qwetuysdfwi@gmail.com"),
("Joe", "Biden", "+38464573", "gqawfbcvwetuyi@gmail.com"),
("Bob", "Marley", "+12323426", "qwetawdxuyi@gmail.com"),
("Tony", "Hawk", "+8756456745", "1qweqwevcbfwetuyi@gmail.com"),
("Laura", "Donnelly", "+28939475694", "qweuynhgnftuyi@gmail.com"),
("Liza", "Weil", "+97062742323", "yumngfgbqwetuyi@gmail.com"),
("Chack", "Norris", "+8346823", "qw5uih95ung5etuyi@gmail.com"),
("Andrew", "Garfield", "+09820731", "q4og5j4859gwetuyi@gmail.com");


INSERT INTO `rentee` (name, surname, phone_number, email, gender, birthday) VALUES
("Sergiy", "Ivaniv", "+38348573", "qwetuyi@gmail.com", "male", "2000-02-26"),
("Bohdan", "Bohdanov", "+3823877", "qwetuyisdfxzcz@gmail.com", "male", "2001-02-26"),
("Anthony", "Ivaniv", "+383956773", "qwetuysdfwi@gmail.com", "male", "2002-02-26"),
("Joe", "Biden", "+38464573", "gqawfbcvwetuyi@gmail.com", "male", "2000-01-26"),
("Bob", "Marley", "+12323426", "qwetawdxuyi@gmail.com", "male", "2000-12-29"),
("Tony", "Hawk", "+8756456745", "1qweqwevcbfwetuyi@gmail.com", "male", "2001-06-26"),
("Laura", "Donnelly", "+28939475694", "qweuynhgnftuyi@gmail.com", "female", "2001-11-16"),
("Liza", "Weil", "+97062742323", "yumngfgbqwetuyi@gmail.com", "female", "2000-07-16"),
("Chack", "Norris", "+8346823", "qw5uih95ung5etuyi@gmail.com", "male", "2001-09-19"),
("Andrew", "Garfield", "+09820731", "q4og5j4859gwetuyi@gmail.com", "male", "2000-03-26");


INSERT INTO `appartment` (area, room_number, overall_rating, price_per_day, renter_id) VALUES
(120, 3, 9, 1000, 1),
(100, 4, 8, 1200, 2),
(110, 2, 7, 200, 3),
(90, 2, 6, 100, 4),
(130, 5, 10, 900, 5),
(140, 4, 10, 1100, 6),
(80, 4, 9, 1150, 7),
(60, 4, 7, 1200, 8),
(210, 6, 5, 1500, 9),
(150, 5, 7, 1200, 10);


INSERT INTO `appartment_adress` (country, city, street, house_number, appartment_number, appartment_id) VALUES
('Ukraine', 'Dnipro', 'Shevchenka', 12, 1, 1),
('Ukraine', 'Lviv', 'Svobody', 100, 13, 2),
('Ukraine', 'Kyiv', 'Khreshchatyk', 63, 2, 3),
('Ukraine', 'Lviv', 'Sakharova', 23, 4, 4),
('Ukraine', 'Lviv', 'Horodotska', 58, 7, 5),
('Ukraine', 'Lviv', 'Zelena', 17, 3, 6),
('Ukraine', 'Ternopil', 'Shevchenka', 19, 5, 7),
('Ukraine', 'Zhytomyr', 'Peremohy', 34, 67, 8),
('Ukraine', 'Kyiv', 'Lesi Ukrainky', 41, 89, 9),
('Ukraine', 'Odesa', 'Melnytska', 21, 4, 10);


INSERT INTO `request` (start_date, end_date, rentee_id, appartment_id) VALUES
('2022-11-26', '2022-11-27', 1, 2),
('2022-12-29', '2022-12-30', 2, 5),
('2022-10-01', '2022-10-02', 3, 6),
('2023-01-01', '2022-01-05', 4, 3),
('2022-12-27', '2022-12-31', 5, 1),
('2022-12-16', '2022-12-17', 6, 7),
('2022-10-18', '2022-10-19', 7, 4),
('2022-09-15', '2022-09-17', 8, 8),
('2022-11-23', '2022-11-24', 9, 10),
('2022-12-08', '2022-12-10', 10, 9);


INSERT INTO `available_time` (start_date, end_date) VALUES 
('2022-11-10', '2022-11-20'),
('2022-10-10', '2022-10-20'),
('2022-12-10', '2022-12-20'),
('2022-09-10', '2022-09-20'),
('2022-08-10', '2022-08-20'),
('2022-08-20', '2022-11-30'),
('2022-11-01', '2022-11-20'),
('2022-12-01', '2022-12-31'),
('2022-12-05', '2022-12-10'),
('2022-10-07', '2022-10-15');


INSERT INTO `appartment_time` (appartment_id, available_time_id) VALUES 
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 5),
(4, 6),
(5, 1),
(6, 7),
(6, 2),
(7, 8),
(8, 10),
(9, 1),
(10, 3);


INSERT INTO `response` (photo_href, text_response, rating) VALUES
('href', 'Nice house!', 10),
('href', 'Good house!', 8),
('href', 'Great house!', 9),
('href', 'Nice!', 10),
('href', 'Good!', 8),
('href', 'Great!', 7),
('href', 'Terrible!', 1),
('href', 'Not bad!', 5),
('href', 'Not bad!', 6),
('href', 'Nice house!!!!', 10);


INSERT INTO `appartment_response` (response_id, appartment_id) VALUES
(1, 2),
(2, 2),
(3, 1),
(4, 3),
(5, 5),
(6, 6),
(7, 9),
(8, 10),
(9, 4);