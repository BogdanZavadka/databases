package com.lab4.dao.impl;

import com.lab4.dao.RenterDao;
import com.lab4.domain.Renter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterDaoImpl implements RenterDao {
    private static final String FIND_ALL = "SELECT * FROM renter;";
    private static final String FIND_BY_ID = "SELECT * FROM renter WHERE id=?;";
    private static final String CREATE = "INSERT INTO renter" +
            " (name, surname, phone_number, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE renter SET " +
            "name=?, surname=?, phone_number=?, email=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM renter WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public RenterDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Renter> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Renter.class));
    }

    @Override
    public Optional<Renter> findById(Integer id) {
        Optional<Renter> renters;
        try {
            renters = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Renter.class), id));
        } catch (Exception e) {
            renters = Optional.empty();
        }
        return renters;
    }

    @Override
    public int create(Renter renter) {
        return jdbcTemplate.update(CREATE, renter.getName(), renter.getSurname(), renter.getPhoneNumber(), renter.getEmail());
    }

    @Override
    public int update(Integer id, Renter renter) {
        return jdbcTemplate.update(UPDATE, renter.getName(), renter.getSurname(), renter.getPhoneNumber(), renter.getEmail(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
