package com.vaibhav.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class SousCategoryService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Integer> getVus() { // this for SousCategory vus
        return jdbcTemplate.query("SELECT * FROM test.sous_category;", new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int i) throws SQLException {
                return rs.getInt("vus");
            }
        });
    }
}
