package com.lab4.dao.impl;

import com.lab4.dao.RenteeDao;
import com.lab4.domain.Rentee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenteeDaoImpl implements RenteeDao {
    private static final String FIND_ALL = "SELECT * FROM rentee;";
    private static final String FIND_BY_ID = "SELECT * FROM rentee WHERE id=?;";
    private static final String CREATE = "INSERT INTO rentee" +
            " (name, surname, phone_number, email, gender, birthday) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE rentee SET " +
            "name=?, surname=?, phone_number=?, email=?, gender=?, birthday=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM rentee WHERE id=?;";
    private static final String FIND_BY_GENDER = "SELECT FROM rentee WHERE gender=?;";

    private final JdbcTemplate jdbcTemplate;

    public RenteeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Rentee> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Rentee.class));
    }

    @Override
    public Optional<Rentee> findById(Integer id) {
        Optional<Rentee> rentees;
        try {
            rentees = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Rentee.class), id));
        } catch (Exception e) {
            rentees = Optional.empty();
        }
        return rentees;
    }

    @Override
    public int create(Rentee rentee) {
        return jdbcTemplate.update(CREATE, rentee.getName(), rentee.getSurname(), rentee.getPhoneNumber(), rentee.getEmail(),
                rentee.getGender(), rentee.getBirthday());
    }

    @Override
    public int update(Integer id, Rentee rentee) {
        return jdbcTemplate.update(UPDATE, rentee.getName(), rentee.getSurname(), rentee.getPhoneNumber(), rentee.getEmail(),
                rentee.getGender(), rentee.getBirthday(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<List<Rentee>> getRenteesByGender(String gender) {
        Optional<List<Rentee>> rentees;
        try {
            rentees = Optional.of(jdbcTemplate.query(FIND_BY_GENDER,
                    BeanPropertyRowMapper.newInstance(Rentee.class), gender));
        } catch (Exception e) {
            rentees = Optional.empty();
        }
        return rentees;
    }
}
