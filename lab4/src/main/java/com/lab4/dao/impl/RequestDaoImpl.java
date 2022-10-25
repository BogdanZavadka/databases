package com.lab4.dao.impl;

import com.lab4.dao.RequestDao;
import com.lab4.domain.Request;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestDaoImpl implements RequestDao {
    private static final String FIND_ALL = "SELECT * FROM request;";
    private static final String FIND_BY_ID = "SELECT * FROM request WHERE id=?;";
    private static final String CREATE = "INSERT INTO request" +
            " (name, surname, phone_number, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE request SET " +
            "name=?, surname=?, phone_number=?, email=? WHERE id=?;";
    private static final String DELETE = "DELETE FROM request WHERE id=?;";

    private final JdbcTemplate jdbcTemplate;

    public RequestDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Request> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Request.class));
    }

    @Override
    public Optional<Request> findById(Integer id) {
        Optional<Request> request;
        try {
            request = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Request.class), id));
        } catch (Exception e) {
            request = Optional.empty();
        }
        return request;
    }

    @Override
    public int create(Request request) {
        return jdbcTemplate.update(CREATE, request.getStartDate(), request.getEndDate(), request.getRenteeId(),
                request.getAppartmentId());
    }

    @Override
    public int update(Integer id, Request request) {
        return jdbcTemplate.update(UPDATE, request.getStartDate(), request.getEndDate(), request.getRenteeId(),
                request.getAppartmentId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
