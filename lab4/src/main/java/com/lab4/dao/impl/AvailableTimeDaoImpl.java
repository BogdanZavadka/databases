package com.lab4.dao.impl;

import com.lab4.dao.AvailableTimeDao;
import com.lab4.domain.AvailableTime;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailableTimeDaoImpl implements AvailableTimeDao {
    private static final String FIND_ALL = "SELECT * FROM available_time;";
    private static final String FIND_BY_ID = "SELECT * FROM available_time WHERE id=?;";
    private static final String CREATE = "INSERT INTO available_time" +
            " (start_date, end_date) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE available_time SET " +
            "start_date=?, end_date=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM available_time WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public AvailableTimeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AvailableTime> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(AvailableTime.class));
    }

    @Override
    public Optional<AvailableTime> findById(Integer id) {
        Optional<AvailableTime> time;
        try {
            time = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(AvailableTime.class), id));
        } catch (Exception e) {
            time = Optional.empty();
        }
        return time;
    }

    @Override
    public int create(AvailableTime availableTime) {
        return jdbcTemplate.update(CREATE, availableTime.getStartDate(), availableTime.getEndDate());
    }

    @Override
    public int update(Integer id, AvailableTime availableTime) {
        return jdbcTemplate.update(UPDATE, availableTime.getStartDate(), availableTime.getEndDate(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
