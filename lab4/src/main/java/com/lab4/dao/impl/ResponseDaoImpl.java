package com.lab4.dao.impl;

import com.lab4.dao.ResponseDao;
import com.lab4.domain.Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseDaoImpl implements ResponseDao {
    private static final String FIND_ALL = "SELECT * FROM response JOIN appartment_response a " +
            "ON response.id=a.response_id;";
    private static final String FIND_BY_ID = "SELECT * FROM response WHERE id=?;";
    private static final String CREATE = "INSERT INTO response" +
            " (photo_href, text_response, rating) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE response SET " +
            "photo_href=?, text_response=?, rating=?WHERE id=?;";
    private static final String DELETE = "DELETE FROM response WHERE id=?;";

    private static final String FIND_BY_RATING = "SELECT FROM response WHERE rating=?;";

    private final JdbcTemplate jdbcTemplate;

    public ResponseDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Response> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Response.class));
    }

    @Override
    public Optional<Response> findById(Integer id) {
        Optional<Response> responses;
        try {
            responses = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Response.class), id));
        } catch (Exception e) {
            responses = Optional.empty();
        }
        return responses;
    }

    @Override
    public int create(Response request) {
        return jdbcTemplate.update(CREATE, request.getPhotoHref(), request.getTextResponse(), request.getRating());
    }

    @Override
    public int update(Integer id, Response request) {
        return jdbcTemplate.update(UPDATE, request.getPhotoHref(), request.getTextResponse(), request.getRating(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<List<Response>> getResponsesByRating(Integer rating) {
        Optional<List<Response>> responses;
        try {
            responses = Optional.of(jdbcTemplate.query(FIND_BY_RATING,
                    BeanPropertyRowMapper.newInstance(Response.class), rating));
        } catch (Exception e) {
            responses = Optional.empty();
        }
        return responses;
    }
}
