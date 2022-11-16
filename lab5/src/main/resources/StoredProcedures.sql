USE air_bnb;

DELIMITER //
DROP PROCEDURE IF EXISTS getAvarageAppartmentPrice //
CREATE PROCEDURE getAvarageAppartmentPrice(
    OUT avg_price float
)
BEGIN
    set avg_price = get_avarage_price_of_appartment();
END //

DROP PROCEDURE IF EXISTS insertIntoRentee;
CREATE PROCEDURE insertIntoRentee(
    IN new_name VARCHAR(30),
    IN new_surname VARCHAR(35),
    IN new_phone_number VARCHAR(15),
    IN new_email VARCHAR(100),
    IN new_gender VARCHAR(6),
    IN new_birthday VARCHAR(12),
    IN new_rentee_balance_id int
)
BEGIN
    INSERT INTO rentee(name, surname, phone_number, email, gender, birthday, rentee_balance_id)
        VALUE (new_name, new_surname, new_phone_number, new_email, new_gender, new_birthday, new_rentee_balance_id);
    SELECT id, name, surname, phone_number, email, gender, birthday, rentee_balance_id FROM rentee WHERE name=new_name AND surname=new_surname AND phone_number=new_phone_number
    AND email=new_email AND gender=new_gender AND birthday=new_birthday AND rentee_balance_id=new_rentee_balance_id;
end //

DROP PROCEDURE IF EXISTS insertResponses //
CREATE PROCEDURE insertResponses(
IN responseText VARCHAR(30)
)
BEGIN
    DECLARE counter INT;
    SET counter = 1;
    my_loop: LOOP
        if counter > 10 THEN LEAVE my_loop;
            END IF;
        INSERT INTO response(photo_href, text_response, rating) VALUE ('http', CONCAT(responseText, counter), 10);
        SET counter = counter + 1;
    END LOOP;
END //

DROP PROCEDURE IF EXISTS createTables //
CREATE PROCEDURE createTables()
BEGIN
    DECLARE done BOOLEAN DEFAULT false;
    DECLARE rentee_name VARCHAR(15);
    DECLARE rand_int int DEFAULT 1;
    DECLARE i INT DEFAULT 1;
    DECLARE text_query VARCHAR(200) DEFAULT '';
    DECLARE lab_cursor CURSOR FOR
        SELECT name FROM rentee;
    DECLARE CONTINUE HANDLER FOR
        NOT FOUND SET done = true;
    OPEN lab_cursor;
    lab_loop: LOOP
        FETCH lab_cursor INTO rentee_name;
        IF (done = true) THEN LEAVE lab_loop;
        END IF;
        SET rand_int =  FLOOR(RAND()*10+1);
        SET i = 1;
        SET text_query = '';
        rand_loop: LOOP
            IF (i > rand_int) THEN LEAVE rand_loop;
            END IF;
            IF (i = rand_int) THEN SET text_query = CONCAT(text_query, 'Column', i, ' int');
            ELSE SET text_query = CONCAT(text_query, 'Column', i, ' int', ', ');
            END IF;
            SET i = i + 1;
        END LOOP;
        SET @temp_query = CONCAT('CREATE TABLE IF NOT EXISTS `', rentee_name, DATE_FORMAT(NOW(), '_%Y_%m_%d_%H_%i_%s'), '` (', text_query, ');');
        PREPARE my_query FROM @temp_query;
        EXECUTE my_query;
        DEALLOCATE PREPARE my_query;
    END LOOP;
    CLOSE lab_cursor;
END //
DELIMITER ;