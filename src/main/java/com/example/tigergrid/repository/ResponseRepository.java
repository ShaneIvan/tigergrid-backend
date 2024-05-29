package com.example.tigergrid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tigergrid.model.Response.*;

public interface ResponseRepository extends JpaRepository<ResponseAnswer, Integer> {
}