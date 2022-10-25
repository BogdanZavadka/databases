package com.lab4.dao.impl;

import com.lab4.dao.AppartmentDao;
import com.lab4.domain.Appartment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartmentDaoImpl implements AppartmentDao {

    private static final String FIND_ALL = "SELECT * FROM appartment;";
    private static final String FIND_BY_ID = "SELECT * FROM appartment WHERE id=?;";
    private static final String CREATE = "INSERT INTO appartment" +
            " (area, room_number, overall_rating, price_per_day, renter_id) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE appartment SET " +
            "area=?, room_number=?, overall_rating=?, price_per_day=?, renter_id=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM appartment WHERE id=?;";
    private static final String FIND_BY_RATING = "SELECT FROM appartment WHERE rating=?;";

    private final JdbcTemplate jdbcTemplate;

    public AppartmentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<List<Appartment>> getAppartmentsByRating(Integer rating) {
        Optional<List<Appartment>> appartments;
        try {
            appartments = Optional.of(jdbcTemplate.query(FIND_BY_RATING,
                    BeanPropertyRowMapper.newInstance(Appartment.class), rating));
        } catch (Exception e) {
            appartments = Optional.empty();
        }
        return appartments;
    }

    @Override
    public List<Appartment> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Appartment.class));
    }

    @Override
    public Optional<Appartment> findById(Integer id) {
        Optional<Appartment> appartments;
        try {
            appartments = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Appartment.class), id));
        } catch (Exception e) {
            appartments = Optional.empty();
        }
        return appartments;
    }

    @Override
    public int create(Appartment appartment) {
        return jdbcTemplate.update(CREATE, appartment.getArea(), appartment.getRoomNumber(), appartment.getOverallRating(),
                appartment.getPricePerDay(), appartment.getRenterId());
    }

    @Override
    public int update(Integer id, Appartment appartment) {
        return jdbcTemplate.update(UPDATE, appartment.getArea(), appartment.getRoomNumber(), appartment.getOverallRating(),
                appartment.getPricePerDay(), appartment.getRenterId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
