package com.marlena.beautyschool.repository;

import com.marlena.beautyschool.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Event> findAllEvents() {
        String sql = "SELECT * FROM EVENTS";
        var rowMapper = BeanPropertyRowMapper.newInstance(Event.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

}
