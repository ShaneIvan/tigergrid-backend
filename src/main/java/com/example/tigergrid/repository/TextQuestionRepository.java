package com.example.tigergrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tigergrid.model.Form.TextQuestion;

@Repository
public interface TextQuestionRepository extends JpaRepository<TextQuestion, Long> {
}