package com.example.tigergrid.repository;

import com.example.tigergrid.model.Form.Form;
import com.example.tigergrid.model.Form.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Integer> {
}
