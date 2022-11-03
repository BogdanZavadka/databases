package com.lab4.dao.impl;

import com.lab4.dao.AppartmentAdressDao;
import com.lab4.domain.AppartmentAdress;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class AppartmentAdressDaoImpl implements AppartmentAdressDao {
    private static final String FIND_ALL = "SELECT * FROM appartment_adress;";
    private static final String FIND_BY_ID = "SELECT * FROM appartment_adress WHERE id=?;";
    private static final String CREATE = "INSERT INTO appartment_adress" +
            " (country, city, street, house_number, appartment_number, appartment_id) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE appartment_adress SET " +
            "country=?, city=?, street=?, house_number=?, appartment_number=?, appartment_id=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM appartment_adress WHERE id=?;";

    private static final String FIND_BY_COUNTRY = "SELECT * FROM appartment_adress WHERE country=?;";

    private final JdbcTemplate jdbcTemplate;

    public AppartmentAdressDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<List<AppartmentAdress>> getAppartmentsByCountry(String country) {
        Optional<List<AppartmentAdress>> adresses;
        try {
            adresses = Optional.of(jdbcTemplate.query(FIND_BY_COUNTRY,
                    BeanPropertyRowMapper.newInstance(AppartmentAdress.class), country));
        } catch (Exception e) {
            adresses = Optional.empty();
        }
        return adresses;
    }

    @Override
    public List<AppartmentAdress> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(AppartmentAdress.class));
    }

    @Override
    public Optional<AppartmentAdress> findById(Integer id) {
        Optional<AppartmentAdress> address;
        try {
            address = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(AppartmentAdress.class), id));
        } catch (Exception e) {
            address = Optional.empty();
        }
        return address;
    }

    @Override
    public int create(AppartmentAdress address) {
        return jdbcTemplate.update(CREATE, address.getCountry(), address.getCity(), address.getStreet(), address.getHouseNumber(),
                address.getAppartmentNumber(), address.getAppartmentId());
    }

    @Override
    public int update(Integer id, AppartmentAdress address) {
        return jdbcTemplate.update(UPDATE, address.getCountry(), address.getCity(), address.getStreet(), address.getHouseNumber(),
                address.getAppartmentNumber(), address.getAppartmentId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
