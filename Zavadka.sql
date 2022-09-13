-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-11 08:49:15.397

-- tables
-- Table: appartment
CREATE TABLE appartment (
    id int NOT NULL AUTO_INCREMENT,
    adress varchar(150) NOT NULL,
    area int NULL,
    room_nember int NULL,
    overall_rating int NOT NULL,
    price_per_day int NOT NULL,
    renter_id int NOT NULL,
    CONSTRAINT appartment_pk PRIMARY KEY (id)
);

-- Table: appartment_adress
CREATE TABLE appartment_adress (
    id int NOT NULL AUTO_INCREMENT,
    country varchar(50) NOT NULL,
    city varchar(50) NOT NULL,
    street varchar(50) NOT NULL,
    house_number int NOT NULL,
    appartment_number int NULL,
    appartment_id int NOT NULL,
    CONSTRAINT appartment_adress_pk PRIMARY KEY (id)
);

-- Table: appartment_photos
CREATE TABLE appartment_photos (
    photos_id int NOT NULL,
    appartment_id int NOT NULL,
    CONSTRAINT appartment_photos_pk PRIMARY KEY (photos_id,appartment_id)
);

-- Table: appartment_response
CREATE TABLE appartment_response (
    response_id int NOT NULL,
    appartment_id int NOT NULL,
    CONSTRAINT appartment_response_pk PRIMARY KEY (appartment_id,response_id)
);

-- Table: appartment_time
CREATE TABLE appartment_time (
    appartment_id int NOT NULL,
    available_time_id int NOT NULL,
    CONSTRAINT appartment_time_pk PRIMARY KEY (appartment_id,available_time_id)
);

-- Table: available_time
CREATE TABLE available_time (
    id int NOT NULL AUTO_INCREMENT,
    start_date date NOT NULL,
    end_date int NOT NULL,
    CONSTRAINT available_time_pk PRIMARY KEY (id)
);

-- Table: photos
CREATE TABLE photos (
    id int NOT NULL,
    photo_href varchar(150) NOT NULL,
    title varchar(100) NULL,
    CONSTRAINT photos_pk PRIMARY KEY (id)
);

-- Table: rentee
CREATE TABLE rentee (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    surname varchar(35) NOT NULL,
    gender varchar(5) NOT NULL,
    birthday date NULL,
    phone_number varchar(20) NOT NULL,
    email varchar(150) NOT NULL,
    CONSTRAINT rentee_pk PRIMARY KEY (id)
);

-- Table: rentee_balance
CREATE TABLE rentee_balance (
    rentee_id int NOT NULL,
    currency varchar(4) NOT NULL,
    money_amount int NULL,
    money_to_pay int NULL,
    CONSTRAINT rentee_balance_pk PRIMARY KEY (rentee_id)
);

-- Table: renter
CREATE TABLE renter (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    surname varchar(35) NOT NULL,
    phone_number varchar(20) NOT NULL,
    email varchar(150) NOT NULL,
    CONSTRAINT renter_pk PRIMARY KEY (id)
);

-- Table: renter_balance
CREATE TABLE renter_balance (
    renter_id int NOT NULL,
    currency int NOT NULL,
    money_amount int NULL,
    money_to_get int NULL,
    CONSTRAINT renter_balance_pk PRIMARY KEY (renter_id)
);

-- Table: request
CREATE TABLE request (
    id int NOT NULL AUTO_INCREMENT,
    start_date date NOT NULL,
    end_date date NOT NULL,
    rentee_id int NOT NULL,
    appartment_id int NOT NULL,
    CONSTRAINT request_pk PRIMARY KEY (id)
);

-- Table: response
CREATE TABLE response (
    id int NOT NULL,
    photo_href varchar(150) NULL,
    text_response varchar(300) NOT NULL,
    rating int NULL,
    CONSTRAINT response_pk PRIMARY KEY (id)
);

-- Table: service
CREATE TABLE service (
    id int NOT NULL,
    rentee_balance_rentee_id int NOT NULL,
    received_money int NULL,
    renter_balance_renter_id int NOT NULL,
    CONSTRAINT service_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: appartment_adress_appartment (table: appartment_adress)
ALTER TABLE appartment_adress ADD CONSTRAINT appartment_adress_appartment FOREIGN KEY appartment_adress_appartment (appartment_id)
    REFERENCES appartment (id);

-- Reference: appartment_photos_appartment (table: appartment_photos)
ALTER TABLE appartment_photos ADD CONSTRAINT appartment_photos_appartment FOREIGN KEY appartment_photos_appartment (appartment_id)
    REFERENCES appartment (id);

-- Reference: appartment_photos_photos (table: appartment_photos)
ALTER TABLE appartment_photos ADD CONSTRAINT appartment_photos_photos FOREIGN KEY appartment_photos_photos (photos_id)
    REFERENCES photos (id);

-- Reference: appartment_renter (table: appartment)
ALTER TABLE appartment ADD CONSTRAINT appartment_renter FOREIGN KEY appartment_renter (renter_id)
    REFERENCES renter (id);

-- Reference: appartment_response_appartment (table: appartment_response)
ALTER TABLE appartment_response ADD CONSTRAINT appartment_response_appartment FOREIGN KEY appartment_response_appartment (appartment_id)
    REFERENCES appartment (id);

-- Reference: appartment_response_response (table: appartment_response)
ALTER TABLE appartment_response ADD CONSTRAINT appartment_response_response FOREIGN KEY appartment_response_response (response_id)
    REFERENCES response (id);

-- Reference: appartment_time_appartment (table: appartment_time)
ALTER TABLE appartment_time ADD CONSTRAINT appartment_time_appartment FOREIGN KEY appartment_time_appartment (appartment_id)
    REFERENCES appartment (id);

-- Reference: appartment_time_available_time (table: appartment_time)
ALTER TABLE appartment_time ADD CONSTRAINT appartment_time_available_time FOREIGN KEY appartment_time_available_time (available_time_id)
    REFERENCES available_time (id);

-- Reference: balance_rentee (table: rentee_balance)
ALTER TABLE rentee_balance ADD CONSTRAINT balance_rentee FOREIGN KEY balance_rentee (rentee_id)
    REFERENCES rentee (id);

-- Reference: renter_balance_renter (table: renter_balance)
ALTER TABLE renter_balance ADD CONSTRAINT renter_balance_renter FOREIGN KEY renter_balance_renter (renter_id)
    REFERENCES renter (id);

-- Reference: request_appartment (table: request)
ALTER TABLE request ADD CONSTRAINT request_appartment FOREIGN KEY request_appartment (appartment_id)
    REFERENCES appartment (id);

-- Reference: request_rentee (table: request)
ALTER TABLE request ADD CONSTRAINT request_rentee FOREIGN KEY request_rentee (rentee_id)
    REFERENCES rentee (id);

-- Reference: service_rentee_balance (table: service)
ALTER TABLE service ADD CONSTRAINT service_rentee_balance FOREIGN KEY service_rentee_balance (rentee_balance_rentee_id)
    REFERENCES rentee_balance (rentee_id);

-- Reference: service_renter_balance (table: service)
ALTER TABLE service ADD CONSTRAINT service_renter_balance FOREIGN KEY service_renter_balance (renter_balance_renter_id)
    REFERENCES renter_balance (renter_id);

-- End of file.

