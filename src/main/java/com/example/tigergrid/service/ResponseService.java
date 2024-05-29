package com.example.tigergrid.service;

import com.example.tigergrid.model.Response.*;
import com.example.tigergrid.repository.ResponseRepository;

import org.apache.camel.quarkus.component.servlet.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ResponseService {
    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    

    public void uploadAnswer(String answer) {
        String sql = "INSERT INTO custom_answer (answer) VALUES (?)";
        jdbcTemplate.update(sql, answer);
    }

    public void saveResponseAnswer(int customAnswerId, int questionId) {
        String sql = "INSERT INTO response_answer (answer, question) VALUES (?, ?)";
        jdbcTemplate.update(sql, customAnswerId, questionId);
    }

    public void saveResponse(String formTitle) {
        String sql = "INSERT INTO response (form_title) VALUES (?)";
        jdbcTemplate.update(sql, formTitle);
    }

    public void saveUserResponse(int userid, int responseId) {
        String sql = "INSERT INTO user_responses (user_id, responses_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, userid, responseId);
    }

    public int getLastInsertId(){
        String sql = "SELECT LAST_INSERT_ID()";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }


    public void saveAllResponses(List<ResponseAnswer> responses) {
        responses.forEach(response -> {
            responseRepository.save(response);
        });
    }


}
