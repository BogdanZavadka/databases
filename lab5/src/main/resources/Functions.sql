USE air_bnb;

set global log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS get_avarage_price_of_appartment;
DELIMITER //
CREATE FUNCTION get_avarage_price_of_appartment()
RETURNS float
BEGIN
RETURN (SELECT avg(price_per_day) FROM appartment);
END //
DELIMITER ;