package com.example.tigergrid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tigergrid.model.Form.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByFormId(int formId);
}