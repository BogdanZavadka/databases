USE air_bnb;

DELIMITER //
DROP TRIGGER IF EXISTS onCreateRentee //
CREATE TRIGGER onCreateRentee
    BEFORE INSERT
    ON rentee FOR EACH ROW
BEGIN
    IF(NOT EXISTS(SELECT id FROM rentee WHERE id = NEW.rentee_balance_id))
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'FK error: No rentee_balance with such id';
    END IF;
END //

DROP TRIGGER IF EXISTS onDeleteRenteeBalance //
CREATE TRIGGER onDeleteRenteeBalance
    BEFORE DELETE
    ON rentee_balance FOR EACH ROW
BEGIN
    DELETE FROM rentee WHERE rentee.rentee_balance_id = OLD.id;
END //

DROP TRIGGER IF EXISTS checkToZeros //
CREATE TRIGGER checkToZeros
    BEFORE INSERT
    ON rentee_balance FOR EACH ROW
BEGIN
    IF(NEW.money_amount RLIKE '.*00$')
    THEN SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'money_amount cannot end with 00';
    END IF;
END//

DROP TRIGGER IF EXISTS forbitUpdate //
CREATE TRIGGER forbitUpdate
    BEFORE UPDATE
    ON rentee_balance FOR EACH ROW
BEGIN
    SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot update this table';
END //

DROP TRIGGER IF EXISTS checkName //
CREATE TRIGGER checkName
    BEFORE INSERT
    ON rentee FOR EACH ROW
BEGIN
    IF (NEW.name != 'Svitlana' AND NEW.name != 'Petro' AND NEW.name != 'Olha' AND NEW.name != 'Taras')
        THEN SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Rentee name not in Svitlana, Petro, Olha, Taras';
    END IF;
END //

DELIMITER ;